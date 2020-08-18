package com.example.danielapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    public TimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        Bundle args = getArguments();
        String date = args.getString(Constans.ARG_DATE);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Queue");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String otherDate = ds.child("Date").getValue(String.class);
                    String otherTime = ds.child("Time").getValue(String.class);
                    if (otherDate.equals(date) && otherTime.equals(b1.getText().toString())) {
                        b1.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b2.getText().toString())) {
                        b2.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b3.getText().toString())) {
                        b3.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b4.getText().toString())) {
                        b4.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b5.getText().toString())) {
                        b5.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b6.getText().toString())) {
                        b6.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b7.getText().toString())) {
                        b7.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b8.getText().toString())) {
                        b8.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b9.getText().toString())) {
                        b9.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b10.getText().toString())) {
                        b10.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b11.getText().toString())) {
                        b11.setEnabled(false);
                    }if (otherDate.equals(date) && otherTime.equals(b12.getText().toString())) {
                        b12.setEnabled(false);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        b1 = view.findViewById(R.id.btn_Nine);
        b1.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b1.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });
        b2 = view.findViewById(R.id.btn_tTen);
        b2.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b2.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);

        });
        b3 = view.findViewById(R.id.btn_Eleven);
        b3.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b3.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);

        });
        b4 = view.findViewById(R.id.btn_Twelve);
        b4.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b4.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });
        b5 = view.findViewById(R.id.btn_One);
        b5.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b5.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b6 = view.findViewById(R.id.btn_Two);
        b6.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b6.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b7 = view.findViewById(R.id.btn_Four);
        b7.setOnClickListener(v -> {

            NavController navController = Navigation.findNavController(v);
            String time = b7.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b8 = view.findViewById(R.id.btn_Five);
        b8.setOnClickListener(v -> {

            NavController navController = Navigation.findNavController(v);
            String time = b8.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b9 = view.findViewById(R.id.btn_Six);
        b9.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b9.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b10 = view.findViewById(R.id.btn_Seven);
        b10.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b10.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b11 = view.findViewById(R.id.btn_NinePm);
        b11.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b11.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        b12 = view.findViewById(R.id.btn_TenPm);
        b12.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            String time = b12.getText().toString();
            args.putString("time", time);
            navController.navigate(R.id.action_timeFragment_to_beforeLastPage, args);
        });

        return view;
    }
}
