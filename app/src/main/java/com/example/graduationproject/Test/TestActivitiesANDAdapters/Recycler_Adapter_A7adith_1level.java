package com.example.graduationproject.Test.TestActivitiesANDAdapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_A7adith_1level;

import java.util.List;

public class Recycler_Adapter_A7adith_1level extends RecyclerView.Adapter<Recycler_Adapter_A7adith_1level.ViewHolder_recycler> {
    List<String> A7adith_one_level_list ;
    OnClickListener_A7adith_1level onClickListener_7adith ;
   // public boolean itemChecked = false ;
    public  int counter_checked = 0 ;
    Context context ;
    public Recycler_Adapter_A7adith_1level(Context context ,List<String> a7adith_one_level_list, OnClickListener_A7adith_1level onClickListener_7adith) {
        this.context = context ;
        A7adith_one_level_list =  a7adith_one_level_list;
        this.onClickListener_7adith = onClickListener_7adith;
    }

    @NonNull
    @Override
    public ViewHolder_recycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_check_7adith,null,false);
        return new ViewHolder_recycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_recycler holder, int position) {
     String hadith_one_level = A7adith_one_level_list.get(position);
     holder.tv_check_7adith.setText(hadith_one_level);
    // holder.checkBox_7adith.getA
    }

    @Override
    public int getItemCount() {
        return A7adith_one_level_list.size();
    }

    public class ViewHolder_recycler extends RecyclerView.ViewHolder{
    TextView tv_check_7adith;
    CheckBox checkBox_7adith;
    public final String CHECKBOX_KEY = "Shared_key_checkList" ;
    public final String SHARED_PREF_NAME = "Shared_checkList";
    SharedPreferences sp_check_list = PreferenceManager.getDefaultSharedPreferences(context);
    //SharedPreferences sp_check_list = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    SharedPreferences.Editor edit_check_list  = sp_check_list.edit();
   // boolean checked = sp_check_list.getBoolean()

        public ViewHolder_recycler(@NonNull View itemView) {
            super(itemView);
            tv_check_7adith = itemView.findViewById(R.id.tv_check_7adith);
            checkBox_7adith = itemView.findViewById(R.id.checkbox_7adith);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 onClickListener_7adith.onClick(getAdapterPosition());  // may need it
                }
            });

            checkBox_7adith.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // boolean checkBoolean = checkBox_7adith.isChecked();
                    edit_check_list.putBoolean(CHECKBOX_KEY,checkBox_7adith.isChecked());
                    edit_check_list.apply();
                    if (checkBox_7adith.isChecked()){
                        counter_checked++ ;
                       //Toast.makeText(context,counter_checked +""+A7adith_one_level_list.size(), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        counter_checked--;
                    }

                       if(counter_checked == A7adith_one_level_list.size())
                       {onClickListener_7adith.allChecked(true);}
                       else {onClickListener_7adith.allChecked(false);}
                }
            });





    }

}}
