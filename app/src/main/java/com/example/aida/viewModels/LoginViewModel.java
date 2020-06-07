package com.example.aida.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.aida.models.User;

public class LoginViewModel extends ViewModel {
    private User user;

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
}
