package com.example.aida.dal;

import com.example.aida.viewModels.ViewModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class RestService {
    protected ViewModel viewModel;
    protected FirebaseFirestore database;

    protected String usersPath = "users";
    protected String citiesPath = "cities";
    protected String countriesPath = "countries";
    protected String entriesPath = "entries";
    protected String foodsPath = "foods";

    public RestService(){
        database = FirebaseFirestore.getInstance();
    }

    public RestService(ViewModel viewModel) {
        this.viewModel = viewModel;
        this.database = FirebaseFirestore.getInstance();
    }
}
