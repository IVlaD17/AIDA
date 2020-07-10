package com.example.aida.viewModels.legacy;

import androidx.lifecycle.ViewModel;

import com.example.aida.models.userModels.User;

public class LoginViewModel extends ViewModel {
    private User user;

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
}
