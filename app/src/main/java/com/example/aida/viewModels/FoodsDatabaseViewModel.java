package com.example.aida.viewModels;

import com.example.aida.dal.FoodManager;
import com.example.aida.models.foodModels.FoodsDatabase;

public class FoodsDatabaseViewModel implements ViewModel {
    private FoodsDatabase model;
    private FoodManager foodsRepo;
    private String pageName;

    public FoodsDatabaseViewModel() {
        model = new FoodsDatabase();
        foodsRepo = new FoodManager(this, null);
        pageName = "NoPageName";
    }

    public FoodsDatabaseViewModel(String pageName) {
        this.model = new FoodsDatabase();
        this.foodsRepo = new FoodManager(this, null);
        this.pageName = pageName;
    }

    public FoodsDatabaseViewModel(FoodsDatabase model, FoodManager foodsRepo, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new FoodsDatabase();
        }

        if(foodsRepo != null) {
            this.foodsRepo = foodsRepo;
        } else {
            this.foodsRepo = new FoodManager(this, null);
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

    public void onDetailsBtnTapped() {
        //TODO: Implement Method
    }

    public void onAddToMealBtnTapped() {
        //TODO: Implement Method
    }

    private void toggleDetailFields() {
        //TODO: Implement Method
    }

    private void navigateToMealManagement() {
        //TODO: Implement Method
    }
}
