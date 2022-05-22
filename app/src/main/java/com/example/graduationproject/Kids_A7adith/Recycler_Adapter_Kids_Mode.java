package com.example.graduationproject.Kids_A7adith;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_A7adith_details;
import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycler_Adapter_Kids_Mode extends RecyclerView.Adapter<Recycler_Adapter_Kids_Mode.Kids_Vh> {
    Context context ;
    ArrayList<Kids_A7adith_details> list_Kids_A7adith;
   // ArrayList<String> list_Kids_A7adith;
    OnClickListener_A7adith_1level listener_kids_A7adith;
    static boolean visible ;
    public Recycler_Adapter_Kids_Mode(Context context ,ArrayList<Kids_A7adith_details> list_Kids_A7adith, OnClickListener_A7adith_1level listener_kids_A7adith) {
       this.context = context;
        this.list_Kids_A7adith = list_Kids_A7adith;
        this.listener_kids_A7adith = listener_kids_A7adith;
    }

    public Recycler_Adapter_Kids_Mode(String image, OnClickListener_A7adith_1level listener_kids_a7adith) {
    }

    @NonNull
    @Override
    public Kids_Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Kids_Vh v = new Kids_Vh(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_a7adith_kids,null));
        return v ;
    }

    @Override
    public void onBindViewHolder(@NonNull Kids_Vh holder, int position) {
        //   String imagePath = list_Kids_A7adith.get(position);
        Kids_A7adith_details kids_a7adith_list  = list_Kids_A7adith.get(position);
       holder.img_7adith.setImageResource(Integer.parseInt(kids_a7adith_list.getIamgePath()));
       Glide.with(context).load(list_Kids_A7adith.get(position).getIamgePath()).into(holder.img_7adith);

       // Glide.with(context).load(list_Kids_A7adith.get(position).getImage()).placeholder(R.drawable.back_educational_recycler)
            //    .error(R.drawable.ic_launcher_background).into(holder.img_7adith);

    //  Picasso.with(context).load(img_7adith.getImage()).into(holder.img_7adith);

    }

    /*
 @Override
    public void onBindViewHolder(@NonNull Kids_Vh holder, int position) {
        //   String imagePath = list_Kids_A7adith.get(position);
        Kids_A7adith_details kids_a7adith_list  = list_Kids_A7adith.get(position);
       holder.img_7adith.setImageResource(Integer.parseInt(kids_a7adith_list.getIamgePath()));
       Glide.with(context).load(list_Kids_A7adith.get(position).getIamgePath()).into(holder.img_7adith);

       // Glide.with(context).load(list_Kids_A7adith.get(position).getImage()).placeholder(R.drawable.back_educational_recycler)
            //    .error(R.drawable.ic_launcher_background).into(holder.img_7adith);

    //  Picasso.with(context).load(img_7adith.getImage()).into(holder.img_7adith);

    }
 */

    @Override
    public int getItemCount() {
        return list_Kids_A7adith.size();
    }

    public class Kids_Vh extends RecyclerView.ViewHolder{
        ImageView img_7adith;
        public Kids_Vh(@NonNull View itemView) {
            super(itemView);
            img_7adith = itemView.findViewById(R.id.card_img_7adith);
     itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
         listener_kids_A7adith.onClick(getAdapterPosition());
         }});
        }
    }
}
