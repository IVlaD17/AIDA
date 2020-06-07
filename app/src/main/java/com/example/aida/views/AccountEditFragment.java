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

import com.example.aida.R;
import com.example.aida.models.City;
import com.example.aida.viewModels.AccountEditViewModel;
import com.example.aida.utility.Constants;
import com.example.aida.models.Country;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AccountEditFragment extends Fragment {

    private AccountEditViewModel cViewModel;
    private View cRootView;

    private TextInputLayout fNameInputField;
    private TextInputLayout lNameInputField;
    private TextInputLayout phoneInputField;
    private TextInputLayout passInputField;
    private TextInputLayout cPassInputField;
    private TextInputLayout countryInputField;
    private TextInputLayout cityInputField;
    private TextInputLayout addressInputField;
    private TextInputLayout diabetesInputField;

    public static AccountEditFragment newInstance() {
        return new AccountEditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cRootView = inflater.inflate(R.layout.fragment_account_edit, container, false);

        initFields();
        initCountriesDropdown();
        initCitiesDropdown();
        initDiabetesTypesDropdown();

        MainActivity.cAddJournalItemFAB.setVisibility(View.GONE);
        MainActivity.cAddMealItemFAB.setVisibility(View.GONE);

        return cRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(AccountEditViewModel.class);
    }

    void initFields(){
        fNameInputField = cRootView.findViewById(R.id.fNameTextInputAEF);
        fNameInputField.getEditText().setText(MainActivity.loggedUser.getFirstName());

        lNameInputField = cRootView.findViewById(R.id.lNameTextInputAEF);
        lNameInputField.getEditText().setText(MainActivity.loggedUser.getLastName());

        phoneInputField = cRootView.findViewById(R.id.phoneTextInputAEF);
        phoneInputField.getEditText().setText(MainActivity.loggedUser.getTelephone());

        passInputField = cRootView.findViewById(R.id.passwordTextInputAEF);
        cPassInputField = cRootView.findViewById(R.id.cPasswordTextInputAEF);

        countryInputField = cRootView.findViewById(R.id.countryExposedDropdownMenuAEF);
        countryInputField.getEditText().setText(MainActivity.loggedUser.getCountry().toString());

        cityInputField = cRootView.findViewById(R.id.cityExposedDropdownMenuAEF);
        cityInputField.getEditText().setText(MainActivity.loggedUser.getCity().toString());

        addressInputField = cRootView.findViewById(R.id.addressTextInputAEF);
        addressInputField.getEditText().setText(MainActivity.loggedUser.getAddress());

        diabetesInputField = cRootView.findViewById(R.id.diabetesExposedDropdownMenuAEF);
        diabetesInputField.getEditText().setText(MainActivity.loggedUser.getDiabetesType());
    }

    void initCountriesDropdown(){
        ArrayAdapter<Country> countryArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, MainActivity.countries);
        final AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.countryFilledExposedDropdownAEF);
        editTextFilledExposedDropdown.setAdapter(countryArrayAdapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountryName = editTextFilledExposedDropdown.getText().toString();
                Country cityOwner = null;
                for(Country country : MainActivity.countries){
                    if(country.getName().equals(selectedCountryName)){
                        cityOwner = country;
                    }
                }

                if(cityOwner != null) {
                    ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, cityOwner.getCities());
                    AutoCompleteTextView cityEditTextFilledExposedDropdown = cRootView.findViewById(R.id.cityFilledExposedDropdownAEF);
                    cityEditTextFilledExposedDropdown.setAdapter(cityArrayAdapter);
                }

            }
        });
    }

    void initCitiesDropdown(){
        ArrayAdapter<City> cityArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, new ArrayList<City>());
        AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.cityFilledExposedDropdownAEF);
        editTextFilledExposedDropdown.setAdapter(cityArrayAdapter);
    }

    void initDiabetesTypesDropdown(){
        ArrayAdapter<String> diabetesTypesArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.DIABETES_TYPES);
        AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.diabetesFilledExposedDropdownAEF);
        editTextFilledExposedDropdown.setAdapter(diabetesTypesArrayAdapter);
    }
}
