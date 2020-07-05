package com.example.aida.viewModels;

import com.example.aida.dal.JournalManager;
import com.example.aida.models.journalModels.Journal;

public class JournalViewModel implements ViewModel {
    private Journal model;
    private JournalManager journalRepo;
    private String pageName;

    public JournalViewModel(){
        model = new Journal();
        journalRepo = new JournalManager(this, null);
        pageName = "NoPageName";
    }

    public JournalViewModel(String pageName) {
        this.model = new Journal();
        this.journalRepo = new JournalManager(this, null);
        this.pageName = pageName;
    }

    public JournalViewModel(Journal model, JournalManager journalRepo, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new Journal();
        }

        if(journalRepo != null) {
            this.journalRepo = journalRepo;
        } else {
            this.journalRepo = new JournalManager(this, null);
        }

        this.pageName = pageName;
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

    public void onSearchBarTapped() {
        //TODO: Implement Method
    }

    public void onSearchClearBtnTapped() {
        //TODO: Implement Method
    }

    public void onAnyBtnTapped() {
        //TODO: Implement Method
    }

    public void onGlycaemiaBtnTapped() {
        //TODO: Implement Method
    }

    public void onCarbsBtnTapped() {
        //TODO: Implement Method
    }

    public void onMedicationBtnTapped() {
        //TODO: Implement Method
    }

    public void onSleepBtnTapped() {
        //TODO: Implement Method
    }

    public void onActivityBtnTapped() {
        //TODO: Implement Method
    }

    public void onCardTapped() {
        //TODO: Implement Method
    }

    public void onCardRemoveBtnTapped() {
        //TODO: Implement Method
    }

    public void onNewBtnTapped() {
        //TODO: Implement Method
    }

    private void toggleDetailFields() {
        //TODO: Implement Method
    }

    private boolean attemptDeleteEntry() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToJournalManagement() {
        //TODO: Implement Method
    }
}
