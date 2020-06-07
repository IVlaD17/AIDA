package com.example.aida.views;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aida.viewModels.AccountManagementViewModel;
import com.example.aida.R;

public class AccountManagement extends Fragment {

    private AccountManagementViewModel viewModel;
    private View view;

    public static AccountManagement newInstance() {
        return new AccountManagement();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account_management, container, false);

        Button completeButton = view.findViewById(R.id.saveButtonAM);

        if(getActivity() instanceof StartActivity)
            completeButton.setText("Start");

        if(getActivity() instanceof MainActivity)
            completeButton.setText("Main");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(AccountManagementViewModel.class);
        // TODO: Use the ViewModel
    }

}
