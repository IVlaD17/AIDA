package com.example.aida.views.legacy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aida.R;
import com.example.aida.models.foodModels.Food;
import com.example.aida.models.userModels.City;
import com.example.aida.models.userModels.Country;
import com.example.aida.models.userModels.User;
import com.example.aida.utility.Constants;
import com.example.aida.utility.Methods;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    private static final String TAG = "StartActivity";

    FirebaseFirestore database;

    Toolbar topAppBar;
    BottomNavigationView botAppBar;

    NavController navController;

    public static ArrayList<Country> countries;
    public static ArrayList<Food> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        topAppBar = findViewById(R.id.toolbar_startup);
        setSupportActionBar(topAppBar);

        botAppBar = findViewById(R.id.bar_bot_nav_startup);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_login, R.id.navigation_register).build();

        navController = Navigation.findNavController(this, R.id.nav_host_startup);

        // Connects the Top App Bar to the Bottom App Bar
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // Connects the Bottom App Bar to the Navigation Host Fragment
        NavigationUI.setupWithNavController(botAppBar, navController);

        database = FirebaseFirestore.getInstance();

        initCountries();
        initFoodItems();
    }

    public void displayLoginFragment() {
        navController.navigate(R.id.navigation_login);
    }
    public void displayMainActivity(User user){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("LoggedUser", user);
        intent.putExtra("Countries", countries);
        intent.putExtra("FoodItems", foodItems);
        startActivity(intent);
    }

    void initCountries(){
        countries = new ArrayList<>();
        database.collection(Constants.COUNTRIES_PATH)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            List<DocumentSnapshot> documents = task.getResult().getDocuments();
                            for (DocumentSnapshot document : documents) {
                                String countryID = document.getId();
                                String countryName = document.getData().get("name").toString();

                                Country newCountry = new Country(countryID, countryName);
                                countries.add(newCountry);
                            }
                            initCities();
                        }
                    }
                });
    }
    void initCities(){
        database.collection(Constants.CITIES_PATH)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            List<DocumentSnapshot> documents = task.getResult().getDocuments();
                            for(DocumentSnapshot document : documents){
                                String cityID = document.getId();
                                String cityName = document.getData().get("name").toString();
                                String cityCountryID = document.getData().get("countryID").toString();

                                Country owner = Methods.findCountryById(cityCountryID, countries);
                                City newCity = new City(cityID, cityName, owner);

                                if(owner != null) {
                                    owner.getCities().add(newCity);
                                }
                            }
                        }
                    }
                });
    }
    void initFoodItems(){
        foodItems = new ArrayList<>();
        database.collection(Constants.FOODS_PATH)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            List<DocumentSnapshot> documents = task.getResult().getDocuments();
                            for(DocumentSnapshot document : documents){
                                Food newFoodItem = Methods.convertDBDataToFoodItem(document);
                                foodItems.add(newFoodItem);
                            }
                        }
                    }
                });
    }
}
