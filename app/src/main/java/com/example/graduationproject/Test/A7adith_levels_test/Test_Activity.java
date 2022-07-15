package com.example.graduationproject.Test.A7adith_levels_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.API_interface;
import com.example.graduationproject.Test.API_Test.Ahadiths_Questions_details;
import com.example.graduationproject.Test.API_Test.Post_Grade_json;
import com.example.graduationproject.Test.API_Test.Test_json;
import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_Radio_Buttons;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Test_Activity extends AppCompatActivity {
//TextView tv_score;
RecyclerView rv_test;
Recycler_Adapter_Test recycler_adapter_test ;
Call<Test_json> call_questions ;
Call<Post_Grade_json> call_post_grade  ;
ArrayList<Integer> id_Ahadith_list = new ArrayList<>() ;
ArrayList<Ahadiths_Questions_details> questions_list ;
public static Button btn_finish_test;
public static boolean finish_test  ;
public static Button btn_moveTo ;
int correctAnswer ;
int score = 0 ;
public  int count = 0;  // count answer num of questions
public static Dialog dialog;
public static boolean show_answers ;

ColorStateList textColorDefaultrb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        finish_test =false ;
        questions_list = new ArrayList<>();
        id_Ahadith_list = getIntent().getExtras().getIntegerArrayList("id_Ahadith_list");
        btn_finish_test = findViewById(R.id.btn_finish_test);
     //   tv_score = findViewById(R.id.tv_show_score);
        // tv_score.append("");
        rv_test = findViewById(R.id.rv_test);
        dialog = new Dialog(Test_Activity.this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://hadith-pedia.herokuapp.com/api/").
                addConverterFactory(GsonConverterFactory.create()).build();
        API_interface api_interface = retrofit.create(API_interface.class);
        // Questions_List .
        for (int i = 0; i < id_Ahadith_list.size(); i++) {
        call_questions = api_interface.getQuestion("Bearer" + " 581|3EbpWw94YjnrjRJ3DLE8bP9NsEHRKli0eanoN81H", id_Ahadith_list.get(i));
        call_questions.enqueue(new Callback<Test_json>() {
            @Override
            public void onResponse(Call<Test_json> call, Response<Test_json> response) {
             //   Toast.makeText(Test_Activity.this, "" + response.isSuccessful(), Toast.LENGTH_SHORT).show();
          questions_list.add(new Ahadiths_Questions_details(response.body().getHadithsQuestion().getQuestion(),
           response.body().getHadithsQuestion().getChoiceA(),response.body().getHadithsQuestion().getChoiceB(),
           response.body().getHadithsQuestion().getChoiceC(),response.body().getHadithsQuestion().getCorrect()));

     recycler_adapter_test = new Recycler_Adapter_Test(Test_Activity.this ,questions_list, new OnClickListener_Radio_Buttons() {

                    @Override
     public void options(RadioGroup rb_group, RadioButton option1, RadioButton option2, RadioButton option3, int position, int index_answer) {
           count++;    //to calculate questions
           correctAnswer = Integer.parseInt(response.body().getHadithsQuestion().getCorrect());
                         //Toast.makeText(Test_Activity.this, "CA"+correctAnswer, Toast.LENGTH_LONG).show();  //correct answer
//                                          if (option1.isChecked() | option2.isChecked() | option3.isChecked()) {}
                        //checkAnswer  "method"
//                                              RadioButton rb_selected = findViewById(rb_group.getCheckedRadioButtonId());
//                                              int answer = rb_group.indexOfChild(rb_selected);
                    //  Toast.makeText(Test_Activity.this, "UA"+index_answer, Toast.LENGTH_LONG).show();       //user answer
                        if (index_answer == correctAnswer) {
                            score++;
                         //   tv_score.setText("الدرجة :" + score + "/ 10");
                        } }

                    @Override
                    public void showSolutions(RadioButton option1, RadioButton option2, RadioButton option3) {
                       // Recycler_Adapter_Test.ViewHolder_recycler.rb_groub.
                        option1.setTextColor(getResources().getColor(R.color.red));
                        option2.setTextColor(getResources().getColor(R.color.red));
                        option3.setTextColor(getResources().getColor(R.color.red));
//                        for(int i = 0 ; i<questions_list.size();i++){ // we need to put position of  radio group}
                        switch (response.body().getHadithsQuestion().getCorrect()) {
                            case "0":
                                option1.setTextColor(getResources().getColor(R.color.ment));
                                break;
                            case "1":
                                option2.setTextColor(getResources().getColor(R.color.ment));
                                break;
                            case "2":
                                option3.setTextColor(getResources().getColor(R.color.ment));
                                break; }
                    }
                });
                rv_test.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rv_test.setAdapter(recycler_adapter_test);
                btn_finish_test.setVisibility(View.VISIBLE);
                btn_finish_test.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // Toast.makeText(Test_Activity.this, count+"", Toast.LENGTH_SHORT).show();
                        if(count<questions_list.size()) {
                            Toast.makeText(Test_Activity.this, "تأكد من إجابة جميع الأسئلة", Toast.LENGTH_SHORT).show();}
                        else {

                             finish_test = true;
                             //recycler_adapter_test.notifyAll();
                             //recycler_adapter_test.notifyDataSetChanged();
                             recycler_adapter_test.notifyItemRangeChanged(0,id_Ahadith_list.size());
                            if (score >= questions_list.size() / 2) {
                                dialog.setContentView(R.layout.custom_dialog_test);
                                TextView tv_score_dialog = dialog.findViewById(R.id.tv_dialog_score);
                                tv_score_dialog.append(" "+score);
                                dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
                                dialog.show();
                                ImageView close = dialog.findViewById(R.id.img_close_test);
                                // moveTo.setEnabled(false);
                                // btn_moveTo = dialog.findViewById(R.id.btn_movetonextlevel);
                                close.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialog.dismiss();
                                        //  moveTo.setEnabled(true);
                                        // dialog_close = true ;
                                        //     Toast.makeText(Test_Activity.this,""+dialog_close,Toast.LENGTH_SHORT).show();
                                    }
                                });
                                //  Toast.makeText(Test_Activity.this, "post"+ score , Toast.LENGTH_SHORT).show();
                                // post score
                                //call_post_grade = api_interface.posGrade("Bearer" + " 443|liwghguqysocASo05g4m6HyqW9tj2j14knxWq0a1", score, 3, response.body().getHadithsQuestion().getLevel_id());
                                call_post_grade = api_interface.postGrade("Bearer" + " 581|3EbpWw94YjnrjRJ3DLE8bP9NsEHRKli0eanoN81H", 3, 11, score);
                                call_post_grade.enqueue(new Callback<Post_Grade_json>() {
                                    @Override
                                    public void onResponse(Call<Post_Grade_json> call, Response<Post_Grade_json> response) {
                                       // Toast.makeText(Test_Activity.this, "ok" + response.isSuccessful(), Toast.LENGTH_SHORT).show();
                                      //  Toast.makeText(Test_Activity.this, "ok" + response.body().getMsg(), Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onFailure(Call<Post_Grade_json> call, Throwable throwable) {
                                        Toast.makeText(Test_Activity.this, "fail", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }else{ Toast.makeText(Test_Activity.this, "لم تجتاز درجة القبول .. برجاء المحاولة مرة أخرى",Toast.LENGTH_SHORT).show();}

                         //   dialog = new Dialog(Test_Activity.this);


//                            btn_moveTo.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                    dialog.dismiss();
//                                    show_answers = true ;
//                                    count++;
//                                    Toast.makeText(Test_Activity.this,show_answers+"",Toast.LENGTH_SHORT).show();
////                                    if(score>=5) {   //put them after turn on show solution .
////                                        Intent intent = new Intent(Test_Activity.this, A7adith_one_level_Activity.class);
////                                        intent.putExtra("levelId",response.body().getHadithsQuestion().getLevel_id()+1);
////                                        startActivity(intent);
////                                    } else {
////                                        Toast.makeText(Test_Activity.this,"عفواَ لابد من إجتياز درجة القبول حتى يمكنك الإنتقال للمستوى التالى ",Toast.LENGTH_SHORT).show();
////                                    }
//                                }});
                                } }
                });
//                if(score>=5){            //delete
//                    // Levels_Activity.progress_level +=10 ;
//                    Levels_Activity.level_num++;  //hnzwedha 3n trek ell intent }
//                }


   //   Toast.makeText(Test_Activity.this,""+ dialog_close,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Test_json> call, Throwable t) {
                // Toast.makeText(Test_Activity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }}); }

       } }



//   option1.setTextColor(R.color.design_default_color_error);
                         /*    if(option1.isPressed() && option1.getText().toString() == response.body().getHadithQuestions().get(position).getCorrect()){
                                   option1.setTextColor(R.color.design_default_color_error);
                                   score = 1;
                                   tv_score.append((Integer.toString(score))+" / 10");
                               }
                               else if(option2.isPressed() && option2.getText().toString() == response.body().getHadithQuestions().get(position).getCorrect()){
                                   option2.setTextColor(R.color.design_default_color_error);
                                   score = 1;
                               }

                               else if(option3.isPressed() && option3.getText().toString() == response.body().getHadithQuestions().get(position).getCorrect()){
                                         option3.setTextColor(R.color.design_default_color_error);
                                         score = 1;
                                     }
                                 }get
                             });*/