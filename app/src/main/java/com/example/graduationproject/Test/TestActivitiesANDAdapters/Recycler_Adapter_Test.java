package com.example.graduationproject.Test.TestActivitiesANDAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.Test.API_Test.Ahadiths_Questions_details;
import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_Radio_Buttons;

import java.util.HashMap;
import java.util.List;

public class Recycler_Adapter_Test extends RecyclerView.Adapter<Recycler_Adapter_Test.ViewHolder_recycler> {
    List<Ahadiths_Questions_details> test_list ;
    HashMap<Integer,Integer>map=new HashMap<>();
   Context context ;
   int positionCard ;
   static OnClickListener_Radio_Buttons listener_radio_buttons;
   int selected_id_h;
    public Recycler_Adapter_Test(Context context ,List<Ahadiths_Questions_details> test_list, OnClickListener_Radio_Buttons listener_radio_buttons) {
        this.test_list = test_list;
        this.listener_radio_buttons = listener_radio_buttons ;
        this.context = context ;
    }

    @NonNull
    @Override
    public Recycler_Adapter_Test.ViewHolder_recycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_test,null,false);
       return new ViewHolder_recycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter_Test.ViewHolder_recycler holder, @SuppressLint("RecyclerView") int position) {
        Ahadiths_Questions_details test_details = test_list.get(position);
        holder.question.setText((position+1)+"- "+test_details.getQuestion());
        holder.radio1.setText(test_details.getChoiceA());
        holder.radio2.setText(test_details.getChoiceB());
        holder.radio3.setText(test_details.getChoiceC());

        positionCard = holder.getAdapterPosition();
//     int selectedId=1;
//       // Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
//      if(holder.radio1.isChecked()){
//          selectedId=holder.radio1.getId();
//      }
//      else if(holder.radio2.isChecked()) {
//          selectedId=holder.radio2.getId();
//      }
//      else if(holder.radio3.isChecked()) {
//          selectedId=holder.radio3.getId();
//      }

        holder. rb_groub.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //checkedId=i;
                // Toast.makeText(context, ""+checkedId, Toast.LENGTH_SHORT).show();

                holder.rb_selected = holder.itemView.findViewById(holder.rb_groub.getCheckedRadioButtonId());
                holder.index_answer = holder.rb_groub.indexOfChild(holder.rb_selected);
                map.put(position,holder.rb_selected.getId());
                // Toast.makeText(context, "hhhh"+map.size(), Toast.LENGTH_SHORT).show();
                listener_radio_buttons.options(holder.rb_groub, holder.radio1, holder.radio2, holder.radio3, holder.getAdapterPosition(), holder.index_answer);
            }});

        if(Test_Activity.show_solutions==true){
            //Toast.makeText(context, "rec"+Test_Activity.show_solutions, Toast.LENGTH_SHORT).show();
            listener_radio_buttons.showSolutions(holder.radio1,holder.radio2,holder.radio3,holder.getAdapterPosition());
        }
        if(Test_Activity.finish_test==true) {
            if(Test_Activity.show_solutions==true){
             //   Toast.makeText(context, "recif"+Test_Activity.show_solutions, Toast.LENGTH_SHORT).show();
                listener_radio_buttons.showSolutions(holder.radio1,holder.radio2,holder.radio3,holder.getAdapterPosition());
            }
           holder.radio2.setClickable(false);
            holder.radio1.setClickable(false);
            holder.radio3.setClickable(false);
            holder.rb_groub.check(map.get(position));// holder.rb_selected.setClickable(true);
        }
//        holder.rb_groub.check(holder.rb_selected.getId());


//        holder.radio1.setChecked(position == selectedPosition );
//        holder.radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//            selectedPosition = holder.getAdapterPosition();
//            listener_radio_buttons.onClick(holder.radio1.getId());
//                }
//            }
//        });
//        holder.radio2.setChecked(position == selectedPosition );
//        holder.radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    selectedPosition = holder.getAdapterPosition();
//                    listener_radio_buttons.onClick(holder.radio2.getId());
//                }
//            }
//        });
//        holder.radio3.setChecked(position == selectedPosition );
//        holder.radio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//             if(b)   {
//                 selectedPosition = holder.getAdapterPosition();
//                 listener_radio_buttons.onClick(holder.radio3.getId());;
//              // delete  listener_radio_buttons.onClick(holder.radio3.getText().toString(),position);
//             }
//            }
//        });
    }
/*  listRadioButtons  = new ArrayList<>();
        listRadioButtons.add(holder.radio1);
        listRadioButtons.add(holder.radio2);
        listRadioButtons.add(holder.radio3);
        for(int i = 0 ; i<3 ;i++){
            selectedPosition = listRadioButtons.get(i);
        holder.selectedRadio.setChecked(position == selectedPosition);
        }*/
    @Override
    public int getItemCount() {
        return test_list.size();
    }

    public  class ViewHolder_recycler extends RecyclerView.ViewHolder{
    TextView question;
   public RadioGroup rb_groub;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton rb_selected;
        int index_answer;
        int checkedId;


        public ViewHolder_recycler(@NonNull View itemView) {
            super(itemView);
            question   =itemView.findViewById(R.id.tv_question);
            rb_groub=itemView.findViewById(R.id.radio_group);
            radio1     =itemView.findViewById(R.id.radio1);
            radio2     =itemView.findViewById(R.id.radio2);
            radio3     =itemView.findViewById(R.id.radio3);



        }
    }

}
