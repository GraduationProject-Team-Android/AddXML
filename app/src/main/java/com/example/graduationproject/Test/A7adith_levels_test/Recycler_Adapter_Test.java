package com.example.graduationproject.Test.A7adith_levels_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.Test.API_Test.Ahadiths_Questions_details;
import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_Radio_Buttons;

import java.util.ArrayList;
import java.util.List;

public class Recycler_Adapter_Test extends RecyclerView.Adapter<Recycler_Adapter_Test.ViewHolder_recycler> {
    List<Ahadiths_Questions_details> test_list ;
   Context context ;
   int positionCard ;
   static OnClickListener_Radio_Buttons listener_radio_buttons;

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
    public void onBindViewHolder(@NonNull Recycler_Adapter_Test.ViewHolder_recycler holder, int position) {
        Ahadiths_Questions_details test_details = test_list.get(position);
        holder.question.setText((position+1)+"- "+test_details.getQuestion());
        holder.radio1.setText(test_details.getChoiceA());
        holder.radio2.setText(test_details.getChoiceB());
        holder.radio3.setText(test_details.getChoiceC());
        positionCard = holder.getAdapterPosition();
        if(Test_Activity.finish_test==true) {
//            for (int i = 0; i < holder.rb_groub.getChildCount(); i++) {
//                holder.rb_groub.getChildAt(i).setClickable(false);
//            }   ho
        listener_radio_buttons.showSolutions(holder.radio1,holder.radio2, holder.radio3);
//            holder.radio2.setClickable(false);
//            holder.radio1.setClickable(false);
//            holder.radio3.setClickable(false);
           // holder.rb_selected.setClickable(true);
         // Toast.makeText(context, ""+holder.checkedId, Toast.LENGTH_SHORT).show();
         //   holder.rb_groub.check(holder.rb_groub.getChildAt(holder.checkedId).getId());
        }


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

    public static class ViewHolder_recycler extends RecyclerView.ViewHolder{
    TextView question;
   public static RadioGroup rb_groub;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
      public static   RadioButton rb_selected;
        int index_answer;
        int checkedId;


        public ViewHolder_recycler(@NonNull View itemView) {
            super(itemView);
            question   =itemView.findViewById(R.id.tv_question);
            rb_groub=itemView.findViewById(R.id.radio_group);
            radio1     =itemView.findViewById(R.id.radio1);
            radio2     =itemView.findViewById(R.id.radio2);
            radio3     =itemView.findViewById(R.id.radio3);
 rb_groub.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        checkedId=i;
       // Toast.makeText(context, ""+checkedId, Toast.LENGTH_SHORT).show();
   rb_selected = itemView.findViewById(rb_groub.getCheckedRadioButtonId());

      //  Toast.makeText(context, "hhhh"+rb_selected.getId(), Toast.LENGTH_SHORT).show();


         index_answer = rb_groub.indexOfChild(rb_selected);
        listener_radio_buttons.options(rb_groub,radio1,radio2,radio3,getAdapterPosition(),index_answer);
    }});



 if(Test_Activity.show_answers){
    // Toast.makeText(context, "recycler", Toast.LENGTH_SHORT).show();
     listener_radio_buttons.showSolutions(radio1,radio2,radio3);          // we need for loop to show solutions .
   }
// else   Toast.makeText(context, "recyclerFalse"+Test_Activity.count, Toast.LENGTH_SHORT).show();

        //    if(Test_Activity.moveTo.isEnabled())  listener_radio_buttons.showSolutions(radio1,radio2,radio3);

//   Test_Activity.btn_finish_test.setOnClickListener(new View.OnClickListener() {
//       @Override
//       public void onClick(View view) {
//
//       }
//   });


///rb_groub.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//
        }
    }

}
