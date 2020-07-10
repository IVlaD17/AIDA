package com.example.aida.views.legacy;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.aida.R;
import com.example.aida.utility.Constants;
import com.example.aida.utility.Methods;
import com.example.aida.viewModels.legacy.LoginViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import static com.example.aida.views.legacy.MainActivity.database;
import static com.example.aida.views.legacy.StartActivity.countries;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;
    private View view;

    private String attemptResult;

    public static LoginFragment newInstance() { return new LoginFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) view.findViewById(R.id.loginButtonLF);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonTapped(view);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    private void onLoginButtonTapped(View view) {
        attemptLogin();

    }
    private void attemptLogin() {
        TextInputLayout emailInputField = view.findViewById(R.id.emailTextInputLF);
        TextInputLayout passwordInputField = view.findViewById(R.id.passwordTextInputLF);

        final String email = emailInputField.getEditText().getText().toString();
        final String password = passwordInputField.getEditText().getText().toString();

        database = FirebaseFirestore.getInstance();

        if(!Methods.isNullOrWhiteSpace(email) && !Methods.isNullOrWhiteSpace(password)) {
            database.collection(Constants.USERS_PATH)
                    .whereEqualTo("email", email)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                List<DocumentSnapshot> documents = task.getResult().getDocuments();
                                if(documents.size() >= 1){
                                    DocumentSnapshot document = documents.get(0);
                                    if(document.exists()){
                                        String dbEmail = document.getData().get("email").toString();
                                        String dbPass = document.getData().get("password").toString();

                                        if(email.equals(dbEmail) && password.equals(dbPass)){
                                            viewModel.setUser(Methods.convertDBDataToUser(document, countries));
                                            attemptResult = Constants.LOGIN_SUCCESS;

                                            ((StartActivity)getActivity()).displayMainActivity(viewModel.getUser());
                                        } else if(!password.equals(dbPass)){
                                            viewModel.setUser(null);
                                            attemptResult = Constants.ERR_PASS_WRONG;
                                        }
                                    }
                                } else {
                                    attemptResult = Constants.ERR_EMAIL_WRONG;
                                }

                                Toast.makeText(getActivity().getApplicationContext(), attemptResult, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
