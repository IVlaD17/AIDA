package com.example.aida.viewModels;

import com.example.aida.dal.LocationManager;
import com.example.aida.dal.UserManager;
import com.example.aida.models.userModels.User;

public class UserManageViewModel extends UserViewModel {
    private LocationManager locationRepo;

    public UserManageViewModel() {
        super();

        locationRepo = new LocationManager(this, null, null);
    }

    public UserManageViewModel(String pageName) {
        super(pageName);

        locationRepo = new LocationManager(this, null, null);
    }

    public UserManageViewModel(User model, UserManager userRepo, String pageName) {
        super(model, userRepo, pageName);

        locationRepo = new LocationManager(this, null, null);
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

    public void onPersonalToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onContactToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onAddressToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onCountryToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onSaveBtnTapped() {
        //TODO: Implement Method
    }

    public void onRegisterBtnTapped() {
        //TODO: Implement Method
    }

    public void onLoginBtnTapped() {
        //TODO: Implement Method
    }

    private void togglePersonalFields() {
        //TODO: Implement Method
    }

    private void toggleContactFields() {
        //TODO: Implement Method
    }

    private void toggleAddressFields() {
        //TODO: Implement Method
    }

    private void updateCityDropdownValues() {
        //TODO: Implement Method
    }

    private boolean verifyInput() {
        //TODO: Implement Method
        return true;
    }

    private boolean attemptLogin() {
        //TODO: Implement Method
        return true;
    }

    private boolean attemptRegistration() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToLogin() {
        //TODO: Implement Method
    }

    private void navigateToProfile() {
        //TODO: Implement Method
    }
}
