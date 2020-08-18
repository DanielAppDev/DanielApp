package com.example.danielapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



/**
 * A simple {@link Fragment} subclass.
 */
public class BeforeLastPage extends Fragment {

    private TextView tv, tv2, tv3;
    private Button finishButton;
    String mAuth = FirebaseAuth.getInstance().getUid();

    public BeforeLastPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_before_last_page, container, false);

        tv = view.findViewById(R.id.tv_one);
        tv2 = view.findViewById(R.id.tv_two);
        tv3 = view.findViewById(R.id.tv_three);
        finishButton = view.findViewById(R.id.btn_finish);

        Bundle args = getArguments();

        if (args != null) {
            String treatment = args.getString(Constans.ARG_TREATMENT);
            String date = args.getString(Constans.ARG_DATE);
            String time  = args.getString("time");

            tv.setText(treatment);
            tv2.setText(date);
            tv3.setText(time);


        finishButton.setOnClickListener(v -> {

            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            alertDialog.setTitle("הודעת מערכת");
            alertDialog.setMessage("הזמנת התור בוצע בהצלחה לכל שינוי או מידע אחר התקשר למספר 050-123-1234");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference("Queue").child(mAuth);
                            myRef1.child("Treatment").setValue(treatment);
                            myRef1.child("Date").setValue(date );
                            myRef1.child("Time").setValue(time);

                            NavController navController = Navigation.findNavController(v);
                            navController.navigate(R.id.action_beforeLastPage_to_navigation_home);
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        });

        }

        return view;
    }

}

