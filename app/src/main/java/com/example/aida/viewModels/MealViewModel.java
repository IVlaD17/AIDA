package com.example.aida.viewModels;

import com.example.aida.models.mealModels.Meal;

public class MealViewModel implements ViewModel {
    private Meal model;
    private String pageName;

    public MealViewModel() {
        model = new Meal();
        pageName = "NoPageName";
    }

    public MealViewModel(String pageName) {
        this.model = new Meal();
        this.pageName = pageName;
    }

    public MealViewModel(Meal model, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new Meal();
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

    public void onBackBtnTapped() {
        //TODO: Implement Method
    }

    public void onCategoryChanged() {
        //TODO: Implement Method
    }

    public void onItemChanged() {
        //TODO: Implement Method
    }

    public void onQuantityChanged() {
        //TODO: Implement Method
    }

    public void onSaveBtnTapped() {
        //TODO: Implement Method
    }

    private void updateItemDropdown() {
        //TODO: Implement Method
    }

    private void updateNutritionalDetails() {
        //TODO: Implement Method
    }

    private void verifyInput() {
        //TODO: Implement Method
    }

    private boolean attemptCreateMeal() {
        //TODO: Implement Method
        return true;
    }

    private boolean attemptUpdateMeal() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToCalculator() {
        //TODO: Implement Method
    }
}
