package com.example.aida.views;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.aida.R;
import com.example.aida.viewModels.JournalAddViewModel;
import com.example.aida.utility.Constants;
import com.google.android.material.textfield.TextInputLayout;

public class JournalAddFragment extends Fragment {

    private JournalAddViewModel cViewModel;
    private View cRootView;

    public static JournalAddFragment newInstance() {
        return new JournalAddFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cRootView = inflater.inflate(R.layout.fragment_journal_add, container, false);

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
        cViewModel = ViewModelProviders.of(this).get(JournalAddViewModel.class);
    }

    void initPrimaryMedicationDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.T1_MEDS);
        final AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.medPrimaryFilledExposedDropdownEAF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout qtyInput = cRootView.findViewById(R.id.medPrimaryTextInputEAF);

                qtyInput.requestFocus();
                qtyInput.setHint(editTextFilledExposedDropdown.getText());

                InputMethodManager inputMethodManager = (InputMethodManager) cRootView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 1);
                }
            }
        });
    }

    void initSecondaryMedicationDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.T2_MEDS);
        final AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.medSecondaryFilledExposedDropdownEAF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout qtyInput = cRootView.findViewById(R.id.medSecondaryTextInputEAF);

                qtyInput.requestFocus();
                qtyInput.setHint(editTextFilledExposedDropdown.getText());

                InputMethodManager inputMethodManager = (InputMethodManager) cRootView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 1);
                }
            }
        });
    }

    void initPhysicalActivityDropdown(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, Constants.ACTIVITIES);
        AutoCompleteTextView editTextFilledExposedDropdown = cRootView.findViewById(R.id.physActFilledExposedDropdownEAF);
        editTextFilledExposedDropdown.setAdapter(adapter);

        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextInputLayout physActTextInputLayout = cRootView.findViewById(R.id.physActExposedDropdownMenuEAF);
                TextInputLayout startTimeInputLayout = cRootView.findViewById(R.id.physActSTTextInputEAF);
                TextInputLayout endTimeInputLayout = cRootView.findViewById(R.id.physActETTextInputEAF);

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
}
