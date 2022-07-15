package com.example.graduationproject.Kids_A7adith;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.R;
import com.example.graduationproject.Test.OnClickListener_Kids;

import java.util.ArrayList;

public class Recycler_Adapter_Kids_Mode extends RecyclerView.Adapter<Recycler_Adapter_Kids_Mode.Kids_Vh> {

      ArrayList<Integer> list_Kids_A7adith;
    OnClickListener_Kids listener_kids_A7adith;

    public Recycler_Adapter_Kids_Mode(ArrayList<Integer> list_Kids_A7adith, OnClickListener_Kids listener_kids_A7adith) {
       //this.context = context;
      //  Toast.makeText(context, "recycler", Toast.LENGTH_SHORT).show();
       this.list_Kids_A7adith = list_Kids_A7adith;
        this.listener_kids_A7adith = listener_kids_A7adith;
    }

    @NonNull
    @Override
    public Recycler_Adapter_Kids_Mode.Kids_Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     //   Toast.makeText(parent.getContext(), "recycler", Toast.LENGTH_SHORT).show();
      // Recycler_Adapter_Kids_Mode.Kids_Vh v = new Recycler_Adapter_Kids_Mode.Kids_Vh(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_a7adith_kids,null,false));
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_a7adith_kids,null,false);
        return new Recycler_Adapter_Kids_Mode.Kids_Vh(v);
        //Kids_Vh v = new Kids_Vh(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_a7adith_kids,null));
       // return v ;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter_Kids_Mode.Kids_Vh holder, int position) {
       Integer intgg=list_Kids_A7adith.get(position);
        holder.img_7adith.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        Toast.makeText(holder.img_7adith.getContext(), "recycler", Toast.LENGTH_SHORT).show();
       // Kids_A7adith_details images_a7adith_list = list_Kids_A7adith.get(position);
      //  Glide.with(holder.itemView.getContext()).load(images_a7adith_list.getIamgePath()).into(holder.img_7adith);
//        Glide.with(holder.itemView.getContext()).load("https://hadith-pedia.herokuapp.com/assets/images/hadithImages/Nngqt9lDPRUHefQ3Qkx8oK5XkniXA9IV9yD08lVD.png")
//                .into(holder.img_7adith);
        /*
        Kids_A7adith_details kids_a7adith_list  = list_Kids_A7adith.get(position);
       holder.img_7adith.setImageResource(Integer.parseInt(kids_a7adith_list.getIamgePath()));
       Glide.with(context).load(list_Kids_A7adith.get(position).getIamgePath()).into(holder.img_7adith); */

    //  Picasso.with(context).load(img_7adith.getImage()).into(holder.img_7adith);

    }



    @Override
    public int getItemCount() {
      //  Toast.makeText(context, "recyclerhhhh", Toast.LENGTH_SHORT).show();
        return  list_Kids_A7adith.size();
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
