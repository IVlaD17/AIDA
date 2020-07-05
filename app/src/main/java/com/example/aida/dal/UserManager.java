package com.example.aida.dal;

import androidx.annotation.NonNull;

import com.example.aida.models.userModels.User;
import com.example.aida.viewModels.ViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserManager extends RestService {
    private ArrayList<User> users;

    public UserManager(ViewModel viewModel, ArrayList<User> users) {
        super(viewModel);

        if(users == null) {
            this.users = new ArrayList<>();
        } else {
            this.users = users;
        }
    }

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

        //TODO: Replace NULL Country and City with actual Values
        return new User(id, firstName, lastName, diabetes, email, password, telephone, address, null, null);
    }

    // Used for Registration
    public void create(final User user) {
        database.collection(usersPath).whereEqualTo("email", user.getEmailAddress()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    if (documents.size() == 0) {
                        // Successful Registration
                        database.collection(usersPath).document().set(user.toDBObject());
                        //TODO: Add Callback Method
                    } else {
                        // Email Already Registered
                        //TODO: Add Callback Method
                    }
                }
            }
        });
    }

    // Used for Logging In
    public void read(final User user) {
        database.collection(usersPath).whereEqualTo("email", user.getEmailAddress()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    if (documents.size() >= 1) {
                        DocumentSnapshot document = documents.get(0);
                        if (document.exists()) {
                            String email = document.getData().get("email").toString();
                            String pass = document.getData().get("password").toString();

                            if(user.getEmailAddress().equals(email) && user.getPassword().equals(pass)){
                                // Successful Login
                                //TODO: Add Callback Method
                            } else if(!user.getPassword().equals(pass)) {
                                // Wrong Password
                                //TODO: Add Callback Method
                            }
                        }
                    } else {
                        // Wrong Email
                        //TODO: Add Callback Method
                    }
                }
            }
        });
    }

    // Used for Account Editing
    public void update(User user) {
        database.collection(usersPath).document(user.getId()).update(user.toDBObject());
    }

    // Used for Account Deletion
    public void delete(User user) {
        database.collection(usersPath).document(user.getId()).delete();
    }
}
