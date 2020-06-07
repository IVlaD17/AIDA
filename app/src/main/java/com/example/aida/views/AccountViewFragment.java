package com.example.aida.views;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aida.R;
import com.example.aida.viewModels.AccountViewViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class AccountViewFragment extends Fragment {

    private AccountViewViewModel cViewModel;

    private TextView cardTitle;
    private TextView cardSubtitle;
    private TextView cardBody;
    private TextInputLayout emailField;
    private TextInputLayout phoneField;

    public static AccountViewFragment newInstance() {
        return new AccountViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View cRootView = inflater.inflate(R.layout.fragment_account_view, container, false);

        cardTitle = cRootView.findViewById(R.id.account_card_title);
        cardSubtitle = cRootView.findViewById(R.id.account_card_subtitle);
        cardBody = cRootView.findViewById(R.id.account_card_body);
        emailField = cRootView.findViewById(R.id.emailLabelAVF);
        phoneField = cRootView.findViewById(R.id.phoneLabelAVF);

        cardTitle.setText(MainActivity.loggedUser.getFirstName() + " " + MainActivity.loggedUser.getLastName());
        cardSubtitle.setText(MainActivity.loggedUser.getDiabetesType());
        cardBody.setText("Address: " + MainActivity.loggedUser.getAddress() + ", " + MainActivity.loggedUser.getCity() + ", "
                + MainActivity.loggedUser.getCountry());
        emailField.getEditText().setText(MainActivity.loggedUser.getEmailAddress());
        phoneField.getEditText().setText(MainActivity.loggedUser.getTelephone());

        MainActivity.cAddJournalItemFAB.setVisibility(View.GONE);
        MainActivity.cAddMealItemFAB.setVisibility(View.GONE);

        return cRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cViewModel = ViewModelProviders.of(this).get(AccountViewViewModel.class);
    }

}
