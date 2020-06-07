package com.example.aida.views;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.aida.R;
import com.example.aida.models.City;
import com.example.aida.models.User;
import com.example.aida.viewModels.RegisterViewModel;
import com.example.aida.utility.Constants;
import com.example.aida.models.Country;
import com.example.aida.utility.Methods;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.example.aida.views.StartActivity.countries;

public class RegisterFragment extends Fragment {

    private RegisterViewModel viewModel;
    private View view;

    private String attemptResult;

    private AutoCompleteTextView countriesDropdown;
    private AutoCompleteTextView citiesDropdown;
    private AutoCompleteTextView diabetesDropdown;

    public static RegisterFragment newInstance() { return new RegisterFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);

        Button loginButton = view.findViewById(R.id.createAccButtonACF);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterButtonTapped(view);
            }
        });

        initCountriesDropdown();
        initCitiesDropdown();
        initDiabetesTypesDropdown();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
    }

    public void onRegisterButtonTapped(View view) {
        attemptRegistration();
    }
    private void attemptRegistration() {
        TextInputLayout fNameInputField = view.findViewById(R.id.fNameTextInputACF);
        TextInputLayout lNameInputField = view.findViewById(R.id.lNameTextInputACF);
        TextInputLayout phoneInputField = view.findViewById(R.id.phoneTextInputACF);
        TextInputLayout emailInputField = view.findViewById(R.id.emailTextInputACF);
        TextInputLayout passInputField = view.findViewById(R.id.passwordTextInputACF);
        TextInputLayout cPassInputField = view.findViewById(R.id.cPasswordTextInputACF);
        TextInputLayout countryInputField = view.findViewById(R.id.countryExposedDropdownMenuACF);
        TextInputLayout cityInputField = view.findViewById(R.id.cityExposedDropdownMenuACF);
        TextInputLayout addressInputField = view.findViewById(R.id.addressTextInputACF);
        TextInputLayout diabetesInputField = view.findViewById(R.id.diabetesExposedDropdownMenuACF);

        final String fName = fNameInputField.getEditText().getText().toString();
        final String lName = lNameInputField.getEditText().getText().toString();
        final String phone = phoneInputField.getEditText().getText().toString();
        final String email = emailInputField.getEditText().getText().toString();
        final String pass = passInputField.getEditText().getText().toString();
        final String cPass = cPassInputField.getEditText().getText().toString();
        final String country = countryInputField.getEditText().getText().toString();
        final String city = cityInputField.getEditText().getText().toString();
        final String address = addressInputField.getEditText().getText().toString();
        final String diabetes = diabetesInputField.getEditText().getText().toString();

        final FirebaseFirestore database = FirebaseFirestore.getInstance();

        if(!Methods.isNullOrWhiteSpace(fName) && !Methods.isNullOrWhiteSpace(lName) && !Methods.isNullOrWhiteSpace(phone)
                && !Methods.isNullOrWhiteSpace(email) && !Methods.isNullOrWhiteSpace(pass) && !Methods.isNullOrWhiteSpace(cPass)
                && !Methods.isNullOrWhiteSpace(country) && !Methods.isNullOrWhiteSpace(city) && !Methods.isNullOrWhiteSpace(address)
                && !Methods.isNullOrWhiteSpace(diabetes)){
            if(pass.equals(cPass)){
                database.collection(Constants.USERS_PATH)
                        .whereEqualTo("email", email)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if(task.isSuccessful()){
                                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                                    if(documents.size() == 0){
                                        viewModel.setUser(new User("", email, pass, fName, lName, phone, address, country, city, diabetes, countries));
                                        database.collection("users").document().set(viewModel.getUser().getDBFormat());
                                        attemptResult = Constants.MSG_ACC_CREATE_SUCCESS;
                                        Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();

                                        ((StartActivity)getActivity()).displayLoginFragment();
                                    }
                                    else{
                                        attemptResult = Constants.ERR_ACC_EXISTS;
                                        Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
            else{
                attemptResult = Constants.ERR_PASS_NO_MATCH;
                Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            attemptResult = Constants.ERR_EMPTY_FIELD;
            Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();
        }
    }

    private void initCountriesDropdown(){
        ArrayAdapter<Country> countryArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, countries);
        countriesDropdown = view.findViewById(R.id.countryFilledExposedDropdownACF);
        countriesDropdown.setAdapter(countryArrayAdapter);

        countriesDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountryName = countriesDropdown.getText().toString();
                Country cityOwner = Methods.findCountryByName(selectedCountryName, countries);

                if(cityOwner != null) {
                    ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, cityOwner.getCities());
                    citiesDropdown.setAdapter(cityArrayAdapter);
                    citiesDropdown.setText("");
                }

            }
        });
    }
    private void initCitiesDropdown(){
        ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, new ArrayList<City>());
        citiesDropdown = view.findViewById(R.id.cityFilledExposedDropdownACF);
        citiesDropdown.setAdapter(cityArrayAdapter);
    }
    private void initDiabetesTypesDropdown(){
        ArrayAdapter<String> diabetesTypesArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.DIABETES_TYPES);
        diabetesDropdown = view.findViewById(R.id.diabetesFilledExposedDropdownACF);
        diabetesDropdown.setAdapter(diabetesTypesArrayAdapter);
    }
}
