package com.example.graduationproject.Kids_A7adith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.API_interface;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_json;
import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.R;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kids_Activity extends AppCompatActivity {
RecyclerView rv_a7adith_kids;
ArrayList<String> list_kids_A7adith_images;
Recycler_Adapter_Kids_Mode rv_kids_Adapter ;
MediaPlayer mediaPlayer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        rv_a7adith_kids = findViewById(R.id.rv_kids_A7adith);
        rv_a7adith_kids.setAdapter(rv_kids_Adapter);
        rv_a7adith_kids.setLayoutManager(new GridLayoutManager(this,2));
        list_kids_A7adith_images = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://hadith-pedia.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        API_interface api_interface = retrofit.create(API_interface.class);
        Call<Kids_json> call = api_interface.getChildHadith();

        call.enqueue(new Callback<Kids_json>() {
            @Override
            public void onResponse(Call<Kids_json> call, Response<Kids_json> response) {

//                list_kids_A7adith_images.add(response.body().getChildhadiths().);   //????
//                list_kids_A7adith_images.add(response.body().getChildhadiths().get(2).getImage());


                rv_kids_Adapter = new Recycler_Adapter_Kids_Mode(Kids_Activity.this ,response.body().getChildhadiths(), new OnClickListener_A7adith_1level() {

                    @Override
                    public void onClick(int position) {
//
//     showDialog_7adith(response.body().getChildhadiths().get(position).getMatn(),response.body().getChildhadiths().get(position).getDescriptin(),
//                              response.body().getChildhadiths().get(position).getAudio());
                     //   showDialog_7adith("نص الحديث");
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                            rv_a7adith_kids.onVisibilityAggregated(false);
//                        }
//                          rv_kids_Adapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onFailure(Call<Kids_json> call, Throwable t) {

            }
//            @Override
//            public void onFailure(Call<Kids_json> call, Throwable t) {
//
//            }
     });


/*
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);
       // list_kids_A7adith_images.add(R.drawable.ic_baseline_check_circle_outline_24);*/


    }
   public  void showDialog_7adith(String matn , String description , String audio){
       Dialog dialog = new Dialog(this);
       dialog.setContentView(R.layout.custom_dialog_kids_7adith);
       dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
      // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
       dialog.setCancelable(false);
       dialog.setCanceledOnTouchOutside(false);
       ImageView btn_close = dialog.findViewById(R.id.img_close_7adith);
       TextView tv_kids_7adith = dialog.findViewById(R.id.tv_kids_7adith);
       ImageView img_play_7adith = dialog.findViewById(R.id.img_play_7adith);
      // ImageView img_replay_7adith = dialog.findViewById(R.id.img_replay_7adith);
       btn_close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dialog.dismiss();

           }
       });
       img_play_7adith.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            playAudio(audio);
           }
       });
       dialog.show();
//       img_replay_7adith.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//           }
//       });
    }
    private void   playAudio(String audio) {
      //  String audioUrl = "https://hadithpedia.herokuapp.com/assets/audios/hadithAudio/rEUiKrcXozmPGisHJir92hHaizJ6T7qyUUwH6Gyp.mp3";
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(audio);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e){
            e.printStackTrace();
        }
        Toast.makeText(Kids_Activity.this, "played", Toast.LENGTH_LONG).show();

    }
}