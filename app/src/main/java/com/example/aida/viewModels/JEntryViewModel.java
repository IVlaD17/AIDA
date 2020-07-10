package com.example.aida.viewModels;

import com.example.aida.dal.JournalManager;
import com.example.aida.models.journalModels.JEntry;
import com.google.android.material.textfield.TextInputLayout;

public class JEntryViewModel implements ViewModel {
    private JEntry model;
    private JournalManager journalRepo;
    private String pageName;
    private TextInputLayout pickerOpener;

    public JEntryViewModel() {
        model = new JEntry();
        journalRepo = new JournalManager(this, null);
        pageName = "NoPageName";
        pickerOpener = null;
    }

    public JEntryViewModel(String pageName) {
        this.model = new JEntry();
        this.journalRepo = new JournalManager(this, null);
        this.pageName = pageName;
        this.pickerOpener = null;
    }

    public JEntryViewModel(JEntry model, JournalManager journalRepo, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new JEntry();
        }

        if(journalRepo != null) {
            this.journalRepo = journalRepo;
        } else {
            this.journalRepo = new JournalManager(this, null);
        }

        this.pageName = pageName;
        this.pickerOpener = null;
    }

    @Override
    public void onCreate() {
        //TODO: Implement Method
    }

    @Override
    public void onPause() {
        //TODO: Implement Method
    }

    @Override
    public void onResume() {
        //TODO: Implement Method
    }

    @Override
    public void onDestroy() {
        //TODO: Implement Method
    }

    public void onBackBtnTapped() {
        //TODO: Implement Method
    }

    public void onBasicToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onMedicationToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onSleepToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onActivityToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onEDateFieldTapped() {
        //TODO: Implement Method
    }

    public void onETimeFieldTapped() {
        //TODO: Implement Method
    }

    public void onPMedDropdownChanged() {
        //TODO: Implement Method
    }

    public void onSMedDropdownChanged() {
        //TODO: Implement Method
    }

    public void onSleepSwitchChanged() {
        //TODO: Implement Method
    }

    public void onSTimeSFieldTapped() {
        //TODO: Implement Method
    }

    public void onSTimeEFieldTapped() {
        //TODO: Implement Method
    }

    public void onActivityDropdownChanged() {
        //TODO: Implement Method
    }

    public void onATimeSFieldTapped() {
        //TODO: Implement Method
    }

    public void onATimeEFieldTapped() {
        //TODO: Implement Method
    }

    public void onSaveBtnTapped() {
        //TODO: Implement Method
    }

    public void onPickerSaveBtnTapped() {
        //TODO: Implement Method
    }

    public void onPickerCloseBtnTapped() {
        //TODO: Implement Method
    }

    private void toggleDatePicker() {
        //TODO: Implement Method
    }

    private void toggleBasicFields() {
        //TODO: Implement Method
    }

    private void toggleMedicationFields() {
        //TODO: Implement Method
    }

    private void toggleSleepFields() {
        //TODO: Implement Method
    }

    private void toggleActivityFields() {
        //TODO: Implement Method
    }

    private void toggleTimePicker() {
        //TODO: Implement Method
    }

    private void togglePMedField() {
        //TODO: Implement Method
    }

    private void toggleSMedField() {
        //TODO: Implement Method
    }

    private void toggleSleepTimeFields() {
        //TODO: Implement Method
    }

    private void toggleActivityActivityFields() {
        //TODO: Implement Method
    }

    private boolean verifyInput() {
        //TODO: Implement Method
        return true;
    }

    private boolean attemptCreateEntry() {
        //TODO: Implement Method
        return true;
    }

    private boolean attemptUpdateEntry() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToJournal() {
        //TODO: Implement Method
    }
}
