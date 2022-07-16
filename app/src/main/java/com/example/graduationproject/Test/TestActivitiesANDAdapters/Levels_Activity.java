package com.example.graduationproject.Test.TestActivitiesANDAdapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.API_interface;
import com.example.graduationproject.R;
import com.example.graduationproject.Test.API_Test.Get_Grades_json;
import com.example.graduationproject.Test.API_Test.Levels_Json;
import com.example.graduationproject.Test.API_Test.Levels_Rating_Grade;
import com.example.graduationproject.Test.API_Test.Levels_details;
import com.example.graduationproject.Test.OnClickListener_Levels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Levels_Activity extends AppCompatActivity {
TextView tv_show_progress_level;
ProgressBar progressBar ;
RecyclerView rv_levels ;
ArrayList<Integer> levels_id_list;
ArrayList<Levels_Rating_Grade> levels_rating_list ;
ArrayList<String> levels_list ;
Recycler_Adapter_Levels recycler_adapter_levels;
public static int level_num  = 1 ;
float grade  = 0.0F;// mean score of test .
//public static int progress_level = 10 ;
//size of gradesssss .

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        tv_show_progress_level = findViewById(R.id.tv_show_progg);
        progressBar = findViewById(R.id.progressBar);
        rv_levels = findViewById(R.id.rv_levels);
        levels_id_list = new ArrayList<>();
        levels_rating_list = new ArrayList<>();
        levels_list = new ArrayList<>();
        levels_list.add("المستوى الأول");
        levels_list.add("المستوى الثانى");
        levels_list.add("المستوى الثالث");
        levels_list.add("المستوى الرابع");
        levels_list.add("المستوى الخامس");
        levels_list.add("المستوى السادس");
        levels_list.add("المستوى السابع");
        levels_list.add("المستوى الثامن");
        levels_list.add("المستوى التاسع");
        levels_list.add("المستوى العاشر");

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://hadith-pedia.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        API_interface api_interface = retrofit.create(API_interface.class);
        //get Levels
        Call<Levels_Json> call_levels = api_interface.getLevels("Bearer" + " 581|3EbpWw94YjnrjRJ3DLE8bP9NsEHRKli0eanoN81H");
        call_levels.enqueue(new Callback<Levels_Json>() {
            @Override
            public void onResponse(Call<Levels_Json> call, Response<Levels_Json> response) {
                Toast.makeText(Levels_Activity.this, response.isSuccessful()+"", Toast.LENGTH_SHORT).show();
                for(int i = 0; i<response.body().getLevels().size();i++) {
                    levels_id_list.add(response.body().getLevels().get(i).getId());
                }
            }

            @Override
            public void onFailure(Call<Levels_Json> call, Throwable t) {

            }
        });

        //get Grade
        Call<Get_Grades_json> call_grade= api_interface.getGrades("Bearer" + " 581|3EbpWw94YjnrjRJ3DLE8bP9NsEHRKli0eanoN81H", 3);
        call_grade.enqueue(new Callback<Get_Grades_json>() {
            @Override
            public void onResponse(Call<Get_Grades_json> call, Response<Get_Grades_json> response) {
             //   Toast.makeText(Levels_Activity.this, "" + response.isSuccessful(), Toast.LENGTH_SHORT).show();
             for (int i = 0 ; i<levels_list.size();i++) {
//                 response.body().getGrades().get(i).getId()
//                 while (response.body().getGrades().get(i) != response.body().getGrades().get(i).getPivot().getLevel_id())
             if(i<response.body().getGrades().size())
             {levels_rating_list.add(new Levels_Rating_Grade(levels_list.get(i),response.body().getGrades().get(i).getPivot().getGrade()));}
             else{ levels_rating_list.add(new Levels_Rating_Grade(levels_list.get(i),0.0f));}
                }

                recycler_adapter_levels = new Recycler_Adapter_Levels(Levels_Activity.this ,levels_rating_list, new OnClickListener_Levels() {
                    @Override
                    public void onClick(int position) {
                        Intent intent = new Intent(Levels_Activity.this, A7adith_one_level_Activity.class);
                        intent.putExtra("levelId", levels_id_list.get(position));
                        startActivity(intent);
                    }

//                    @Override                                                  // delete
//                    public void rating(Button btn_level, RatingBar ratingBar) {
//                        float gradeF = response.body().getGrades().get(0).getPivot().getGrade();
//                         grade = gradeF/2.0F;
//                         ratingBar.setRating(grade);
//
//                    }
     });
     rv_levels.setAdapter(recycler_adapter_levels);
     level_num = response.body().getGrades().size();
    //if(level_num >1)   progressBar.incrementProgressBy(level_num*10);
     progressBar.setProgress(level_num*10);
     tv_show_progress_level.setText(""+level_num*10+"%");


     Toast.makeText(Levels_Activity.this, "grade" + response.body().getGrades().get(0).getPivot().getGrade(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Get_Grades_json> call, Throwable throwable) {

            }
        });
        rv_levels.setLayoutManager(new LinearLayoutManager(this));

    }



}