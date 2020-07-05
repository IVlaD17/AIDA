package com.example.aida.viewModels;

import com.example.aida.models.mealModels.Calculator;

public class CalculatorViewModel implements ViewModel {
    private Calculator model;
    private String pageName;

    public CalculatorViewModel() {
        model = new Calculator();
        pageName = "NoPageName";
    }

    public CalculatorViewModel(String pageName) {
        this.model = new Calculator();
        this.pageName = pageName;
    }

    public CalculatorViewModel(Calculator model, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new Calculator();
        }

        this.pageName = pageName;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onCardTapped() {
        //TODO: Implement Method
    }

    public void onCardRemoveBtnTapped() {
        //TODO: Implement Method
    }

    public void onFABTapped() {
        //TODO: Implement Method
    }

    private void toggleDetailFields() {
        //TODO: Implement Method
    }

    private void updateNutritionalDetails() {
        //TODO: Implement Method
    }

    private boolean attemptDeleteMeal() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToMealManagement() {
        //TODO: Implement Method
    }
}
