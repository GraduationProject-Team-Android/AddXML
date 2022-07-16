package com.example.graduationproject.Test.TestActivitiesANDAdapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.graduationproject.API_interface;
import com.example.graduationproject.R;
import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.Test.API_Test.Ahadith_Level_json;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class A7adith_one_level_Activity extends AppCompatActivity {
RecyclerView rv_a7adith_one_level ;
Button btn_start_test ;
ArrayList<String> A7adith_Check_list;
Recycler_Adapter_A7adith_1level recycler_adapter_a7adith_1level ;
ArrayList<Integer> Ahadiths_id_list ;
boolean allChecked = false ;
//SharedPreferences sp_check_list  = PreferenceManager.getDefaultSharedPreferences(A7adith_one_level_Activity.this);
//SharedPreferences.Editor edit_check_list  = sp_check_list.edit();  //no ned to edit .. because we will restore not save .
public final String CHECKBOX_KEY = "Shared_key_checkList" ;
public static boolean restore_checkbox ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a7adith_one_level);
        int level_num = getIntent().getExtras().getInt("levelId");   // level starts with 11 , you can add 1 to position .
        rv_a7adith_one_level = findViewById(R.id.rv_a7adith_one_level);
        btn_start_test = findViewById(R.id.btn_start_test);
        A7adith_Check_list = new ArrayList<>();
        Ahadiths_id_list  = new ArrayList<>(); // may delete
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://hadith-pedia.herokuapp.com/api/").
                            addConverterFactory(GsonConverterFactory.create()).build();
        API_interface api_interface = retrofit.create(API_interface.class);
        Call<Ahadith_Level_json> call = api_interface.getAhadithLevel("Bearer"+" 581|3EbpWw94YjnrjRJ3DLE8bP9NsEHRKli0eanoN81H",level_num);
        call.enqueue(new Callback<Ahadith_Level_json>() {
            @Override
            public void onResponse(Call<Ahadith_Level_json> call, Response<Ahadith_Level_json> response) {
            Toast.makeText(A7adith_one_level_Activity.this, response.isSuccessful() + "level", Toast.LENGTH_SHORT).show();

                for(int i = 0 ; i<response.body().getLevelHadiths().size() ; i++){
                    A7adith_Check_list.add(response.body().getLevelHadiths().get(i).getMatn());
                }

                for(int i = 0 ; i<response.body().getLevelHadiths().size() ; i++){
             Ahadiths_id_list.add(response.body().getLevelHadiths().get(i).getId()); // may delete
                              }
                Log.d(""+Ahadiths_id_list, "onResponse: ");
                recycler_adapter_a7adith_1level = new Recycler_Adapter_A7adith_1level(A7adith_one_level_Activity.this, A7adith_Check_list, new OnClickListener_A7adith_1level() {
                @Override
                public void onClick(int position) {  // wait rahma
//                    Intent intent = new Intent(A7adith_one_level_Activity.this , 3rdAhadith.class);
//                    intent.putExtra("id",response.body().getLevelHadiths().get(position).getId());
//                    startActivity(intent);
                }
                @Override
                public void allChecked(boolean status_checked) {
                    if(status_checked){
                        allChecked = true ;
               Toast.makeText(A7adith_one_level_Activity.this,"check"+ status_checked , Toast.LENGTH_SHORT).show();
                    }
                    else {allChecked = false ;}
                }

            });
                rv_a7adith_one_level.setAdapter(recycler_adapter_a7adith_1level);
                rv_a7adith_one_level.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                btn_start_test.setVisibility(View.VISIBLE);
                btn_start_test.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

             if(allChecked) {
                            Intent intent = new Intent(A7adith_one_level_Activity.this, Test_Activity.class);
                            intent.putExtra("levelId",level_num);
                            intent.putIntegerArrayListExtra("id_Ahadith_list",Ahadiths_id_list);
                             startActivity(intent);
                               }
             else Toast.makeText(A7adith_one_level_Activity.this, "عذراَ لابد من التأكد من مذاكرة كل الأحاديث الموجودة بالقائمة ", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onFailure(Call<Ahadith_Level_json> call, Throwable throwable) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    //  boolean restore_checkbox = sp_check_list.getBoolean(CHECKBOX_KEY,false);
    }
}