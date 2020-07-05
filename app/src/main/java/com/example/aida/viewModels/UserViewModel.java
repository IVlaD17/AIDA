package com.example.aida.viewModels;

import com.example.aida.dal.UserManager;
import com.example.aida.models.userModels.User;

public class UserViewModel implements ViewModel {
    private User model;
    private UserManager userRepo;
    private String pageName;

    public UserViewModel() {
        model = new User();
        userRepo = new UserManager(this, null);
        pageName = "NoPageName";
    }

    public UserViewModel(String pageName) {
        this.model = new User();
        this.userRepo = new UserManager(this, null);
        this.pageName = pageName;
    }

    public UserViewModel(User model, UserManager userRepo, String pageName) {
        if(model != null) {
            this.model = model;
        } else {
            this.model = new User();
        }

        if(userRepo != null) {
            this.userRepo = userRepo;
        } else {
            this.userRepo = new UserManager(this, null);
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
}
