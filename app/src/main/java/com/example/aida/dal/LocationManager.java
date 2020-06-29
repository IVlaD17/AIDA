package com.example.aida.dal;

import androidx.annotation.NonNull;

import com.example.aida.models.City;
import com.example.aida.models.Country;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LocationManager extends RestService {
    // Used for Getting Countries from the Database
    public void readCountries(){
        database.collection(countriesPath).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    ArrayList<Country> countries = new ArrayList<>();

                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    for(DocumentSnapshot document : documents){
                        String countryID = document.getId();
                        String countryName = document.getData().get("name").toString();

                        Country country = new Country(countryID, countryName);

                        countries.add(country);
                    }

                    //TODO: Add Callback Method
                }
            }
        });
    }

    // Used for Getting Cities from the Database
    public void readCities(final Country country){
        database.collection(citiesPath).whereEqualTo("countryID", country.getId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    for(DocumentSnapshot document : documents){
                        String cityID = document.getId();
                        String cityName = document.getData().get("name").toString();
                        String cityCountryID = document.getData().get("countryID").toString();

                        City city = new City(cityID, cityName, cityCountryID);

                        country.getCities().add(city);
                    }

                    //TODO: Add Callback Method
                }
            }
        });
    }
}
