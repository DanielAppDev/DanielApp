package com.example.danielapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danielapp.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models;
     private View view;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);


        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.mTittle.setText(models.get(position).getTittle());
//        holder.mDes.setText(models.get(position).getDescription());
        holder.mImageView.setImageResource(models.get(position).getImg());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                if (models.get(position).getTittle().equals("טיפול פנים קלאסי")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_faceTreatment);

                }if (models.get(position).getTittle().equals("טיפול זוהר")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_glowTreatment);
                }if (models.get(position).getTittle().equals("טיפול אקנה")) {

                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_acneTreatment);

                }if (models.get(position).getTittle().equals("אנטי אייג'ינג")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_antiAging);
                }if (models.get(position).getTittle().equals("פיגמנטציה")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_pigmentation2);
                }if (models.get(position).getTittle().equals("דיקור קוסמטי")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_faceTreatmentsFragment_to_cosmeticAcupuncture);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
