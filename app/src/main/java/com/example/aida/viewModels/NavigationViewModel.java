package com.example.aida.viewModels;

public class NavigationViewModel implements ViewModel {
    private String pageName;

    public NavigationViewModel() {
        pageName = "NoPageName";
    }

    public NavigationViewModel(String pageName){
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

    public void onJournalBtnTapped() {
        //TODO: Implement Method
    }

    public void onFoodsBtnTapped() {
        //TODO: Implement Method
    }

    public void onProfileBtnTapped() {
        //TODO: Implement Method
    }

    public void onMealBtnTapped() {
        //TODO: Implement Method
    }

    public void onMenuBtnTapped() {
        //TODO: Implement Method
    }

    private void navigateToJournal() {
        //TODO: Implement Method
    }

    private void navigateToFoods() {
        //TODO: Implement Method
    }

    private void navigateToProfile() {
        //TODO: Implement Method
    }

    private void navigateToMeal() {
        //TODO: Implement Method
    }

    private void navigateToMenu() {
        //TODO: Implement Method
    }
}
