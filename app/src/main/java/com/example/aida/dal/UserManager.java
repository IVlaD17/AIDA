package com.example.aida.dal;

import com.example.aida.models.User;
import com.google.firebase.firestore.DocumentSnapshot;

public class UserManager extends RestService {
    //TODO: Add ViewModel Constructor

    // Used for Generating a Food Object from a Database Document
    private User genUser(DocumentSnapshot document){
        String id = document.getId();
        String email = document.getData().get("email").toString();
        String password = document.getData().get("password").toString();

        String firstName = document.getData().get("firstName").toString();
        String lastName = document.getData().get("lastName").toString();

        String telephone = document.getData().get("telephone").toString();

        String address = document.getData().get("address").toString();
        String city = document.getData().get("city").toString();
        String country = document.getData().get("country").toString();

        String diabetes = document.getData().get("diabetesType").toString();

        return new User(id, email, password, firstName, lastName, telephone, address, null, null, diabetes);
    }

    // Used for Registration
    public void create(User user) {

    }

    // Used for Logging In
    public void read(String email, String password) {

    }

    // Used for Account Editing
    public void update(User user) {

    }

    // Used for Account Deletion
    public void delete(User user) {

    }
}
