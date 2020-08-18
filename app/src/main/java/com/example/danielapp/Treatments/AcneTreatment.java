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
public class AcneTreatment extends Fragment {

    private Button order;
    private TextView tvAken;

    public AcneTreatment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acne_treatment, container, false);

        order = view.findViewById(R.id.btn_AkneTreatment);
        tvAken = view.findViewById(R.id.tv_AkneTreatment);
        order.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);

            String akne = tvAken.getText().toString();

            Bundle args = new Bundle();
            args.putString(Constans.ARG_TREATMENT,akne);

            navController.navigate(R.id.action_acneTreatment_to_dateAndTimeFragment,args);
        });

        return view;
    }

}
