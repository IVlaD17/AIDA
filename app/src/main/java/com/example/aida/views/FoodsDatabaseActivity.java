package com.example.aida.views;

//TODO: Implement Class

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.FoodsDatabaseViewModel;
import com.example.aida.viewModels.NavigationViewModel;

public class FoodsDatabaseActivity extends AppCompatActivity {

    private FoodsDatabaseViewModel foodsViewModel;
    private NavigationViewModel navViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_database);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
