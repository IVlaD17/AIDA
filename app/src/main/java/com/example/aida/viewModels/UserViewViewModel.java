package com.example.aida.viewModels;

import com.example.aida.dal.UserManager;
import com.example.aida.models.userModels.User;

public class UserViewViewModel extends UserViewModel {
    public UserViewViewModel() {
        super();
    }

    public UserViewViewModel(String pageName) {
        super(pageName);
    }

    public UserViewViewModel(User user, UserManager userRepo, String pageName) {
        super(user, userRepo, pageName);
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

    public void onLoginBtnTapped() {
        //TODO: Implement Method
    }

    public void onRegisterBtnTapped() {
        //TODO: Implement Method
    }

    public void onDetailsToggleBtnTapped() {
        //TODO: Implement Method
    }

    public void onEditBtnTapped() {
        //TODO: Implement Method
    }

    public void onDeleteBtnTapped() {
        //TODO: Implement Method
    }

    private void toggleDetailFields() {
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

    private boolean attemptDelete() {
        //TODO: Implement Method
        return true;
    }

    private void navigateToMenu() {
        //TODO: Implement Method
    }

    private void navigateToRegistration() {
        //TODO: Implement Method
    }

    private void navigateToLogin() {
        //TODO: Implement Method
    }

    private void navigateToProfileManagement() {
        //TODO: Implement Method
    }
}
