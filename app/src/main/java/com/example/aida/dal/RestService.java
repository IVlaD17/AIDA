package com.example.aida.dal;

import com.google.firebase.firestore.FirebaseFirestore;

public class RestService {
    protected FirebaseFirestore database;

    public RestService(){
        database = FirebaseFirestore.getInstance();
    }
}
