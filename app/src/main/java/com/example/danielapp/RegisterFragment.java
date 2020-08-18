package com.example.danielapp;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private EditText registerName;
    private EditText registerPhone;
    private EditText registerEmail;
    private EditText registerPassword;
    private Button clickToRegister;
    private Button clickToGoBack;

    private ProgressDialog progressDialog;
    User user = new User();

    OnSuccessListener<AuthResult> mSuccessListener = new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(AuthResult authResult) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (getView() != null) {
                NavController navController = Navigation.findNavController(getView());
                navController.navigate(R.id.action_registerFragment_to_loginFragmentt);


                Toast.makeText(getContext(), "המשתמש נוצר בהצלחה", Toast.LENGTH_SHORT).show();
//                String mAuth = FirebaseAuth.getInstance().getUid();
//                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(mAuth);
//                reference.child("name").setValue(getName());
//                reference.child("phoneNumber").setValue(getPhoneNumber());
//                reference.child("email").setValue(getEmail());

                FirebaseManger.shared.saveUser(new User(getName(),getPhoneNumber(),getEmail()));
            }
        }


    };

    OnFailureListener mFailureListener = new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            showError(e);
        }
    };

    private void showError(Exception e) {
        new AlertDialog.Builder(getContext()).setTitle("An Error Occurred").
                setMessage(e.getLocalizedMessage()).
                setPositiveButton("Dissmiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    private void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Logging you in");
            progressDialog.setMessage("Please wait...");
        }

        progressDialog.show();
    }


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerEmail = view.findViewById(R.id.edit_register_email);
        registerPassword = view.findViewById(R.id.edit_register_password);
        clickToRegister = view.findViewById(R.id.btn_register);
        clickToGoBack = view.findViewById(R.id.btn_go_back);
        registerName = view.findViewById(R.id.et_register_name);
        registerPhone = view.findViewById(R.id.et_register_number);


        clickToGoBack.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_registerFragment_to_firstPageFragment);
        });

        clickToRegister.setOnClickListener(v -> {
            register();

        });
    }

    private void register() {
        String name = getName();
        String phone = getPhoneNumber();
        String email = getEmail();
        String pass = getPassword();

        //don't continue if the details are not valid:
        if (email == null || pass == null) {
            return;
        }

        showProgress();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnSuccessListener(mSuccessListener).addOnFailureListener(mFailureListener);

    }


    private String getEmail() {

        String email = registerEmail.getText().toString();

        Pattern emailAddressRegex = Patterns.EMAIL_ADDRESS;
        boolean isEmailValid = emailAddressRegex.matcher(email).matches();

        if (!isEmailValid) {
            registerEmail.setError("אימייל לא תקין");
            return null;
        }
        return email;
    }

    private String getPassword() {

        String pass = registerPassword.getText().toString();

        if (pass.length() < 6) {
            registerPassword.setError("הסיסמא חייבת להכיל לפחות 6 תווים");
            return null;
        }
        return pass;

    }

    private String getName() {
        String name = registerName.getText().toString();
        if (name.isEmpty()) {
            registerName.setError("יש להזין שם");
            return null;
        }
        return name;
    }

    private String getPhoneNumber() {
        String phoneNumber = registerPhone.getText().toString();
        if (phoneNumber.isEmpty()) {
            registerPhone.setError("you need to add Phone Number");
            return null;
        }
        return phoneNumber;
    }
}
