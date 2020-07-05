package com.example.aida.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.aida.models.userModels.User;

public class AccountManagementViewModel extends ViewModel {
    private User user;
    private User loggedUser;

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }

    public void setLoggedUser(User user) { this.loggedUser = user; }
    public User getLoggedUser() { return loggedUser; }
}
