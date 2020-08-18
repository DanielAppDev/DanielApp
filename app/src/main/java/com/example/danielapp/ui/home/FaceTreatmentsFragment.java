package com.example.danielapp.ui.home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danielapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaceTreatmentsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    public FaceTreatmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_face_treatments, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        myAdapter = new MyAdapter(getContext(),getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();

        m.setTittle("טיפול פנים קלאסי");
        m.setImg(R.drawable.tipulpanimklasi);
        models.add(m);

        m = new Model();

        m.setTittle("טיפול זוהר");
        m.setImg(R.drawable.zohar);
        models.add(m);

        m = new Model();

        m.setTittle("טיפול אקנה");
        m.setImg(R.drawable.akne);
        models.add(m);

        m = new Model();

        m.setTittle("אנטי אייג'ינג");
        m.setImg(R.drawable.anti_aging);
        models.add(m);

        m = new Model();

        m.setTittle("פיגמנטציה");
        m.setImg(R.drawable.pigmentsia);
        models.add(m);

        m = new Model();

        m.setTittle("דיקור קוסמטי");
        m.setImg(R.drawable.dikur);
        models.add(m);

        return models;
    }
}
