package com.example.danielapp.Treatments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.danielapp.Constans;
import com.example.danielapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pigmentation extends Fragment {

    private Button btnPigment;
    private TextView tvPigment;
    public Pigmentation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pigmentation, container, false);

        btnPigment = view.findViewById(R.id.btn_OrderPigment);
        tvPigment = view.findViewById(R.id.tv_PigmentTreatment);

        btnPigment.setOnClickListener(v -> {

            NavController navController = Navigation.findNavController(v);
            String pigment = tvPigment.getText().toString();
            Bundle args = new Bundle();
            args.putString(Constans.ARG_TREATMENT,pigment);
            navController.navigate(R.id.action_pigmentation2_to_dateAndTimeFragment,args);
        });


        return view;
    }

}
