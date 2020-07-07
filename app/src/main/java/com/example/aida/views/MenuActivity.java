package com.example.aida.views;

//TODO: Implement Class

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.MenuViewModel;
import com.example.aida.viewModels.NavigationViewModel;

public class MenuActivity extends AppCompatActivity {

    private MenuViewModel menuViewModel;
    private NavigationViewModel navViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
