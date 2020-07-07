package com.example.aida.views;

//TODO: Implement Class

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.CalculatorViewModel;
import com.example.aida.viewModels.NavigationViewModel;

public class CalculatorActivity extends AppCompatActivity {

    private CalculatorViewModel calculatorViewModel;
    private NavigationViewModel navViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
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
