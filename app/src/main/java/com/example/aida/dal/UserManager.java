package com.example.aida.dal;

import com.example.aida.models.User;

public class UserManager extends RestService {
    // Used for Registration
    public boolean create(User user) {
        return false;
    }

    // Used for Logging In
    public User read(String email, String password) {
        return null;
    }

    // Used for Account Editing
    public boolean update(User user) {
        return false;
    }

    // Used for Account Deletion
    public boolean delete(User user) {
        return false;
    }
}
