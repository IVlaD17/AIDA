package com.example.aida.views;

//TODO: Implement Class

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.MealViewModel;

public class MealManageActivity extends AppCompatActivity {

    private MealViewModel mealViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_manage);
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
