package com.example.aida.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.aida.R;
import com.example.aida.models.journalModels.ActivityTypes;
import com.example.aida.utility.Constants;
import com.example.aida.viewModels.JournalEditViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;

public class JournalEditFragment extends Fragment {
    private JournalEditViewModel cViewModel;
    private View cRootView;

    private SwitchMaterial sleepSwitch;
    private TextInputLayout dateInputField;
    private TextInputLayout timeInputField;
    private TextInputLayout glucoseInputField;
    private TextInputLayout carbsInputField;
    private TextInputLayout primaryMedNameInputField;
    private TextInputLayout primaryMedQtyInputField;
    private TextInputLayout secondaryMedNameInputField;
    private TextInputLayout secondaryMedQtyInputField;
    private TextInputLayout sleepStartInputField;
    private TextInputLayout sleepEndInputField;
    private TextInputLayout activityTypeInputField;
    private TextInputLayout activityStartInputField;
    private TextInputLayout activityEndInputField;

    public static JournalEditFragment newInstance() {
        return new JournalEditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cRootView = inflater.inflate(R.layout.fragment_journal_edit, container, false);

        initFields();

        initPrimaryMedicationDropdown();
        initSecondaryMedicationDropdown();
        initPhysicalActivityDropdown();

        MainActivity.cAddJournalItemFAB.setVisibility(View.GONE);
        MainActivity.cAddMealItemFAB.setVisibility(View.GONE);

        return cRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(JournalEditViewModel.class);
    }

    private void initPrimaryMedicationDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.T1_MEDS);
        final AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.medPrimaryFilledExposedDropdownEEF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout qtyInput = cRootView.findViewById(R.id.medPrimaryTextInputEEF);

                qtyInput.requestFocus();
                qtyInput.setHint(editTextFilledExposedDropdown.getText());

                InputMethodManager inputMethodManager = (InputMethodManager) cRootView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 1);
                }
            }
        });
    }
    private void initSecondaryMedicationDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.T2_MEDS);
        final AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.medSecondaryFilledExposedDropdownEEF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout qtyInput = cRootView.findViewById(R.id.medSecondaryTextInputEEF);

                qtyInput.requestFocus();
                qtyInput.setHint(editTextFilledExposedDropdown.getText());

                InputMethodManager inputMethodManager = (InputMethodManager) cRootView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 1);
                }
            }
        });
    }
    private void initPhysicalActivityDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.ACTIVITIES);
        AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.physActFilledExposedDropdownEEF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout physActTextInputLayout = cRootView.findViewById(R.id.physActExposedDropdownMenuEEF);
                TextInputLayout startTimeInputLayout = cRootView.findViewById(R.id.physActSTTextInputEEF);
                TextInputLayout endTimeInputLayout = cRootView.findViewById(R.id.physActETTextInputEEF);

                String dropdownItemText = physActTextInputLayout.getEditText().getText().toString();

                if(dropdownItemText.equals("None") || dropdownItemText.equals("")){
                    startTimeInputLayout.setVisibility(View.GONE);
                    endTimeInputLayout.setVisibility(View.GONE);
                }
                else {
                    startTimeInputLayout.setVisibility(View.VISIBLE);
                    endTimeInputLayout.setVisibility(View.VISIBLE);
                }

                cRootView.clearFocus();
            }
        });
    }

    private void initFields(){
        sleepSwitch = cRootView.findViewById(R.id.sleepSwitchEEF);
        sleepSwitch.setChecked(MainActivity.selectedEntry.getSleep().getHasSlept());

        dateInputField = cRootView.findViewById(R.id.recordDateTextInputEEF);
        dateInputField.getEditText().setText(MainActivity.selectedEntry.getDate().toString());

        timeInputField = cRootView.findViewById(R.id.recordTimeTextInputEEF);
        timeInputField.getEditText().setText(MainActivity.selectedEntry.getTime().toString());

        glucoseInputField = cRootView.findViewById(R.id.glucLvlTextInputEEF);
        glucoseInputField.getEditText().setText(String.valueOf(MainActivity.selectedEntry.getGlucose()));

        carbsInputField = cRootView.findViewById(R.id.carbTextInputEEF);
        carbsInputField.getEditText().setText(String.valueOf(MainActivity.selectedEntry.getCarbohydrates()));

        primaryMedNameInputField = cRootView.findViewById(R.id.medPrimaryExposedDropdownMenuEEF);
        primaryMedNameInputField.getEditText().setText(MainActivity.selectedEntry.getPrimaryMedication().getName());

        primaryMedQtyInputField = cRootView.findViewById(R.id.medPrimaryTextInputEEF);
        primaryMedQtyInputField.getEditText().setText(String.valueOf(MainActivity.selectedEntry.getPrimaryMedication().getQuantity()));

        secondaryMedNameInputField = cRootView.findViewById(R.id.medSecondaryExposedDropdownMenuEEF);
        secondaryMedNameInputField.getEditText().setText(MainActivity.selectedEntry.getSecondaryMedication().getName());

        secondaryMedQtyInputField = cRootView.findViewById(R.id.medSecondaryTextInputEEF);
        secondaryMedQtyInputField.getEditText().setText(String.valueOf(MainActivity.selectedEntry.getSecondaryMedication().getQuantity()));

        sleepStartInputField = cRootView.findViewById(R.id.sleepSTTextInputEEF);
        sleepStartInputField.getEditText().setText(MainActivity.selectedEntry.getSleep().getStart().toString());

        sleepEndInputField = cRootView.findViewById(R.id.sleepETTextInputEEF);
        sleepEndInputField.getEditText().setText(MainActivity.selectedEntry.getSleep().getEnd().toString());

        activityTypeInputField = cRootView.findViewById(R.id.physActExposedDropdownMenuEEF);
        activityTypeInputField.getEditText().setText(MainActivity.selectedEntry.getPhysicalActivity().getType().toString());

        activityStartInputField = cRootView.findViewById(R.id.physActSTTextInputEEF);
        activityStartInputField.getEditText().setText(MainActivity.selectedEntry.getPhysicalActivity().getStart().toString());

        activityEndInputField = cRootView.findViewById(R.id.physActETTextInputEEF);
        activityEndInputField.getEditText().setText(MainActivity.selectedEntry.getPhysicalActivity().getEnd().toString());

        if(MainActivity.selectedEntry.getSleep().getHasSlept()){
            sleepStartInputField.setVisibility(View.VISIBLE);
            sleepEndInputField.setVisibility(View.VISIBLE);
        }

        if(MainActivity.selectedEntry.getPhysicalActivity().getType() != ActivityTypes.NONE){
            activityStartInputField.setVisibility(View.VISIBLE);
            activityEndInputField.setVisibility(View.VISIBLE);
        }
    }
}
