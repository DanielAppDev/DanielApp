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
public class CosmeticAcupuncture extends Fragment {

    private Button btnAcupuncture;
    private TextView tvAcupuncture;


    public CosmeticAcupuncture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cosmetic_acupuncture, container, false);

        tvAcupuncture = view.findViewById(R.id.tv_DikurKosmeti);
        btnAcupuncture = view.findViewById(R.id.btn_DikurKosmeti);
        btnAcupuncture.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);

            String dikur = tvAcupuncture.getText().toString();

            Bundle args = new Bundle();
            args.putString(Constans.ARG_TREATMENT,dikur);

            navController.navigate(R.id.action_cosmeticAcupuncture_to_dateAndTimeFragment,args);

        });

        return view;
    }

}
