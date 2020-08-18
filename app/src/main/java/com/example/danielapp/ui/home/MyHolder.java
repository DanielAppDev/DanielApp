package com.example.danielapp.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danielapp.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImageView;

    TextView mTittle , mDes;

    ItemClickListener itemClickListener;

     MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.iVimage);
        this.mTittle = itemView.findViewById(R.id.tvText_Tittle);
//        this.mDes = itemView.findViewById(R.id.tvDescription);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

         this.itemClickListener.onItemClickListener(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic){

         this.itemClickListener = ic;
    }
}
