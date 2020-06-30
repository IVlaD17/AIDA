package com.example.aida.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.aida.R;
import com.example.aida.models.userModels.City;
import com.example.aida.models.userModels.Country;
import com.example.aida.models.userModels.User;
import com.example.aida.utility.Constants;
import com.example.aida.utility.Methods;
import com.example.aida.viewModels.AccountManagementViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement extends Fragment {

    private AccountManagementViewModel viewModel;
    private View view;

    private String attemptResult;

    private TextInputLayout fNameInputField;
    private TextInputLayout lNameInputField;
    private TextInputLayout phoneInputField;
    private TextInputLayout emailInputField;
    private TextInputLayout passInputField;
    private TextInputLayout cPassInputField;
    private TextInputLayout countryInputField;
    private TextInputLayout cityInputField;
    private TextInputLayout addressInputField;
    private TextInputLayout diabetesInputField;

    private AutoCompleteTextView countriesDropdown;
    private AutoCompleteTextView citiesDropdown;
    private AutoCompleteTextView diabetesDropdown;

    public static AccountManagement newInstance() {
        return new AccountManagement();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account_management, container, false);

        initFields();
        initButtons();

        initCountriesDropdown();
        initCitiesDropdown();
        initDiabetesDropdown();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(AccountManagementViewModel.class);
    }

    private void onRegisterButtonTapped(View view){
        attemptRegistration();
    }
    private void onEditButtonTapped(View view){
        attemptEdit();
    }

    private void attemptRegistration(){
        attemptResult = "";

        TextInputLayout fNameInputField = view.findViewById(R.id.fNameTextInputAM);
        TextInputLayout lNameInputField = view.findViewById(R.id.lNameTextInputAM);
        TextInputLayout phoneInputField = view.findViewById(R.id.phoneTextInputAM);
        TextInputLayout emailInputField = view.findViewById(R.id.emailTextInputAM);
        TextInputLayout passInputField = view.findViewById(R.id.passwordTextInputAM);
        TextInputLayout cPassInputField = view.findViewById(R.id.cPasswordTextInputAM);
        TextInputLayout countryInputField = view.findViewById(R.id.countryExposedDropdownMenuAM);
        TextInputLayout cityInputField = view.findViewById(R.id.cityExposedDropdownMenuAM);
        TextInputLayout addressInputField = view.findViewById(R.id.addressTextInputAM);
        TextInputLayout diabetesInputField = view.findViewById(R.id.diabetesExposedDropdownMenuAM);

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

        ArrayList<Country> countries = new ArrayList<>();

        if(getActivity() instanceof StartActivity){
            countries = StartActivity.countries;
        } else if(getActivity() instanceof MainActivity){
            countries = MainActivity.countries;
        }

        final ArrayList<Country> fCountries = countries;

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
                                        viewModel.setUser(new User("", email, pass, fName, lName, phone, address, country, city, diabetes, fCountries));
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
    private void attemptEdit(){
        attemptResult = "";

        TextInputLayout fNameInputField;
        TextInputLayout lNameInputField;
        TextInputLayout phoneInputField;
        TextInputLayout passInputField;
        TextInputLayout cPassInputField;
        TextInputLayout countryInputField;
        TextInputLayout cityInputField;
        TextInputLayout addressInputField;
        TextInputLayout diabetesInputField;

        fNameInputField = view.findViewById(R.id.fNameTextInputAM);
        String newFName = fNameInputField.getEditText().getText().toString();
        lNameInputField = view.findViewById(R.id.lNameTextInputAM);
        String newLName = lNameInputField.getEditText().getText().toString();
        phoneInputField = view.findViewById(R.id.phoneTextInputAM);
        String newPhone = phoneInputField.getEditText().getText().toString();
        passInputField = view.findViewById(R.id.passwordTextInputAM);
        String pass = passInputField.getEditText().getText().toString();
        cPassInputField = view.findViewById(R.id.cPasswordTextInputAM);
        String cPass = cPassInputField.getEditText().getText().toString();
        countryInputField = view.findViewById(R.id.countryExposedDropdownMenuAM);
        String newCountry = countryInputField.getEditText().getText().toString();
        cityInputField = view.findViewById(R.id.cityExposedDropdownMenuAM);
        String newCity = cityInputField.getEditText().getText().toString();
        addressInputField = view.findViewById(R.id.addressTextInputAM);
        String newAddress = addressInputField.getEditText().getText().toString();
        diabetesInputField = view.findViewById(R.id.diabetesExposedDropdownMenuAM);
        String newDiabetesType = diabetesInputField.getEditText().getText().toString();

        ArrayList<Country> countries = new ArrayList<>();

        if(getActivity() instanceof StartActivity){
            countries = StartActivity.countries;
        } else if(getActivity() instanceof MainActivity){
            countries = MainActivity.countries;
        }

        final FirebaseFirestore database = FirebaseFirestore.getInstance();

        if(!Methods.isNullOrWhiteSpace(newFName) && !Methods.isNullOrWhiteSpace(newLName) && !Methods.isNullOrWhiteSpace(newPhone)
                && !Methods.isNullOrWhiteSpace(pass) && !Methods.isNullOrWhiteSpace(cPass) && !Methods.isNullOrWhiteSpace(newCountry)
                && !Methods.isNullOrWhiteSpace(newCity) && !Methods.isNullOrWhiteSpace(newAddress) && !Methods.isNullOrWhiteSpace(newDiabetesType)) {
            if (pass.equals(cPass) && pass.equals(MainActivity.loggedUser.getPassword())) {
                User user = new User(MainActivity.loggedUser.getId(), MainActivity.loggedUser.getEmailAddress(), pass, newFName, newLName, newPhone,
                        newAddress, newCountry, newCity, newDiabetesType, countries);
                database.collection(Constants.USERS_PATH).document(MainActivity.loggedUser.getId()).update(user.getDBFormat());

                ((MainActivity)getActivity()).navigateToAccountViewScreen();
            }
            else if(!pass.equals(cPass)){
                attemptResult = Constants.ERR_PASS_NO_MATCH;
            }
            else {
                attemptResult = Constants.ERR_PASS_WRONG;
            }
        }
        else {
            attemptResult = Constants.ERR_EMPTY_FIELD;
        }

        Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();
    }

    private void initFields() {
        if(getActivity() instanceof MainActivity) {
            fNameInputField = view.findViewById(R.id.fNameTextInputAM);
            fNameInputField.getEditText().setText(MainActivity.loggedUser.getFirstName());

            lNameInputField = view.findViewById(R.id.lNameTextInputAM);
            lNameInputField.getEditText().setText(MainActivity.loggedUser.getLastName());

            phoneInputField = view.findViewById(R.id.phoneTextInputAM);
            phoneInputField.getEditText().setText(MainActivity.loggedUser.getTelephone());

            emailInputField = view.findViewById(R.id.emailTextInputAM);
            emailInputField.getEditText().setText(MainActivity.loggedUser.getEmailAddress());

            passInputField = view.findViewById(R.id.passwordTextInputAM);
            cPassInputField = view.findViewById(R.id.cPasswordTextInputAM);

            countryInputField = view.findViewById(R.id.countryExposedDropdownMenuAM);
            countryInputField.getEditText().setText(MainActivity.loggedUser.getCountry().toString());

            cityInputField = view.findViewById(R.id.cityExposedDropdownMenuAM);
            cityInputField.getEditText().setText(MainActivity.loggedUser.getCity().toString());

            addressInputField = view.findViewById(R.id.addressTextInputAM);
            addressInputField.getEditText().setText(MainActivity.loggedUser.getAddress());

            diabetesInputField = view.findViewById(R.id.diabetesExposedDropdownMenuAM);
            diabetesInputField.getEditText().setText(MainActivity.loggedUser.getDiabetesType());
        }
    }
    private void initButtons() {
        Button completeButton = view.findViewById(R.id.saveButtonAM);

        if (getActivity() instanceof StartActivity) {
            completeButton.setText(R.string.btn_register);
            completeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    onRegisterButtonTapped(v);
                }
            });
        }

        if (getActivity() instanceof MainActivity) {
            completeButton.setText(R.string.btn_account_edit);
            completeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    onEditButtonTapped(v);
                }
            });
        }
    }

    private void initCitiesDropdown() {
        ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, new ArrayList<City>());
        citiesDropdown = view.findViewById(R.id.cityFilledExposedDropdownAM);
        citiesDropdown.setAdapter(cityArrayAdapter);
    }
    private void initCountriesDropdown() {
        ArrayList<Country> countries = new ArrayList<>();

        if(getActivity() instanceof StartActivity){
            countries = StartActivity.countries;
        } else if(getActivity() instanceof MainActivity){
            countries = MainActivity.countries;
        }

        ArrayAdapter<Country> countryArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, countries);
        countriesDropdown = view.findViewById(R.id.countryFilledExposedDropdownAM);
        countriesDropdown.setAdapter(countryArrayAdapter);

        final ArrayList<Country> fCountries = countries;

        countriesDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountryName = countriesDropdown.getText().toString();
                Country cityOwner = Methods.findCountryByName(selectedCountryName, fCountries);

                if(cityOwner != null) {
                    ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, cityOwner.getCities());
                    citiesDropdown.setAdapter(cityArrayAdapter);
                    citiesDropdown.setText("");
                }

            }
        });
    }
    private void initDiabetesDropdown() {
        ArrayAdapter<String> diabetesTypesArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.DIABETES_TYPES);
        diabetesDropdown = view.findViewById(R.id.diabetesFilledExposedDropdownAM);
        diabetesDropdown.setAdapter(diabetesTypesArrayAdapter);
    }
}
