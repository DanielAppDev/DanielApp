package com.example.danielapp.ui;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danielapp.Constans;
import com.example.danielapp.FirebaseManger;
import com.example.danielapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateFragment extends Fragment {

    private Button btnDate;

    private String mAuth = FirebaseAuth.getInstance().getUid();

    private TextView tvDate;

    private CalendarView calendarView;

    public DateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date, container, false);

        tvDate = view.findViewById(R.id.tv_Date);
        btnDate = view.findViewById(R.id.btn_Date);
        calendarView = view.findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String date = dayOfMonth + "/" + (month + 1) + "/" + year;

                btnDate.setOnClickListener(v -> {

                    NavController navController = Navigation.findNavController(v);
                    Bundle args = getArguments();
                    if (args == null)
                        args = new Bundle();
                    args.putString(Constans.ARG_DATE,date);
                    navController.navigate(R.id.action_dateAndTimeFragment_to_timeFragment,args);

                });
            }
        });



        return view;
    }

}
