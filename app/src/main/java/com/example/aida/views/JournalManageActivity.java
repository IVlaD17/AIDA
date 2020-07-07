package com.example.aida.views;

//TODO: Implement Class

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aida.R;
import com.example.aida.viewModels.JEntryViewModel;

public class JournalManageActivity extends AppCompatActivity {

    private JEntryViewModel entryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_manage);
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
