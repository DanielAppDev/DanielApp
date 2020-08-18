package com.example.danielapp;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragmentt extends Fragment {

    private EditText enterEmail;
    private EditText enterPassword;
    private Button goBack;
    private Button login;

    private ProgressDialog progressDialog;




    OnSuccessListener<AuthResult> mSuccessListener = new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            Intent intent = new Intent(getActivity(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    };

    OnFailureListener mFailureListener = new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            showError(e);

        }
    };

    private void showError(Exception e){
        new AlertDialog.Builder(getContext()).setTitle("An Error Occurred").
                setMessage(e.getLocalizedMessage()).
                setPositiveButton("Dissmiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    private void showProgress(){
        if (progressDialog == null){
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Logging you in");
            progressDialog.setMessage("Please wait...");
        }

        progressDialog.show();
    }

    public LoginFragmentt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_fragmentt, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterEmail = view.findViewById(R.id.edit_email);
        enterPassword = view.findViewById(R.id.edit_password);

        goBack = view.findViewById(R.id.go_back);
        goBack.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_loginFragmentt_to_firstPageFragment);
        });


        login = view.findViewById(R.id.btn_login);
        login.setOnClickListener(v -> {
            login();
        });

    }

    private void login(){
        String email = getEmail();
        String pass = getPassword();

        //don't continue if the details are not valid:
        if (email == null || pass == null){
            return;
        }

        showProgress();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnSuccessListener(mSuccessListener).addOnFailureListener(mFailureListener);

    }
    private String getEmail() {

        String email = enterEmail.getText().toString();

        Pattern emailAddressRegex = Patterns.EMAIL_ADDRESS;
        boolean isEmailValid = emailAddressRegex.matcher(email).matches();

        if (!isEmailValid) {
            enterEmail.setError("אימייל לא תקין");
            return null;
        }
        return email;
    }

    private String getPassword() {

        String pass = enterPassword.getText().toString();

        if (pass.length() < 6) {
            enterPassword.setError("הסיסמא חייבת להכיל לפחות 6 תווים");
            return null;
        }
        return pass;

    }

}
