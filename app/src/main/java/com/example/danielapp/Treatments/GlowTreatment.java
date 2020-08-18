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
public class GlowTreatment extends Fragment {

    private Button btnGlowTreatment;
    private TextView tvGlowTreatment;

    public GlowTreatment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_glow_treatment, container, false);

        btnGlowTreatment = view.findViewById(R.id.btn_GlowTreatment);
        tvGlowTreatment = view.findViewById(R.id.tv_GlowTreatment);

        btnGlowTreatment.setOnClickListener(v -> {

            NavController navController = Navigation.findNavController(v);
            String glow = tvGlowTreatment.getText().toString();
            Bundle args = new Bundle();
            args.putString(Constans.ARG_TREATMENT,glow);
            navController.navigate(R.id.action_glowTreatment_to_dateAndTimeFragment,args);
        });

        return view;
    }

}
