package com.example.graduationproject.Test.A7adith_levels_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.Test.API_Test.Levels_Rating_Grade;
import com.example.graduationproject.Test.OnClickListener_Levels;

import java.util.ArrayList;

public class Recycler_Adapter_Levels extends RecyclerView.Adapter<Recycler_Adapter_Levels.ViewHolder_recycler> {
ArrayList<Levels_Rating_Grade> levels_list ;
OnClickListener_Levels onClickListener_level ;
Context context ;
    public Recycler_Adapter_Levels(Context context , ArrayList<Levels_Rating_Grade> levels_list, OnClickListener_Levels onClickListener_level) {
        this.levels_list = levels_list;
        this.onClickListener_level = onClickListener_level;
        this.context = context ;
    }

    @NonNull
    @Override
    public ViewHolder_recycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_level_7adith,null ,false);
        return new ViewHolder_recycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_recycler holder, int position) {
    Levels_Rating_Grade level_rating = levels_list.get(position);
    //String level = level_rating.getName();
    holder.btn_level_num.setText(level_rating.getName());
    holder.rating_bar.setRating(level_rating.getGrade()/2);
  //  notifyDataSetChanged();
   // notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return levels_list.size();
    }

    public class ViewHolder_recycler  extends RecyclerView.ViewHolder{

       Button btn_level_num;
       RatingBar rating_bar ;
        public ViewHolder_recycler(@NonNull View itemView) {
            super(itemView);
            btn_level_num = itemView.findViewById(R.id.btn_num_level);
            rating_bar     = itemView.findViewById(R.id.ratingBar);
            btn_level_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition()<Levels_Activity.level_num) {
                        btn_level_num.setEnabled(true);
                        onClickListener_level.onClick(getAdapterPosition()); }
                    else{
                        itemView.setEnabled(false);
                        Toast.makeText(context, "لابد من إجتياز المستويات السابقة قبل الدخول لهذا المستوى", Toast.LENGTH_SHORT).show();
                    }
                }
            });
         //   onClickListener_level.rating(btn_level_num,rating_bar);
           // onClickListener_level.rating(getAdapterPosition(),btn_level_num,rating_bar); //ask

        }

    }
}


