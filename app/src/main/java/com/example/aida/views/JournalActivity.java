package com.example.aida.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.JournalViewModel;
import com.example.aida.viewModels.NavigationViewModel;

public class JournalActivity extends AppCompatActivity {

    private JournalViewModel journalViewModel;
    private NavigationViewModel navViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
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
