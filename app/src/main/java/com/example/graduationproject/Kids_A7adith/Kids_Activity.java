package com.example.graduationproject.Kids_A7adith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.API_interface;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_A7adith_details;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_json;
import com.example.graduationproject.OnClickListener_A7adith_1level;
import com.example.graduationproject.R;
import com.example.graduationproject.Test.OnClickListener_Kids;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kids_Activity extends AppCompatActivity {
    Button btn ;
RecyclerView rv_a7adith_kids;
    ArrayList <Integer> list_kids_A7adith_images;
ArrayList<Kids_A7adith_details> kids_a7adith_list ;
Animation anim_trans_fade_in ;
Animation anim_trans_bottom_top ;
Animation anim_trans_left_right;
Recycler_Adapter_Kids_Mode rv_kids_Adapter ;
ImageView img_play_7adith;
MediaPlayer mediaPlayer ;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        btn  = findViewById(R.id.button);;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playAudio("https://hadithpedia.herokuapp.com/assets/audios/hadithAudio/rEUiKrcXozmPGisHJir92hHaizJ6T7qyUUwH6Gyp.mp3");
            }
        });
        rv_a7adith_kids = findViewById(R.id.rv_kids_A7adith);
        anim_trans_fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        anim_trans_bottom_top = AnimationUtils.loadAnimation(this,R.anim.translate_bottom_top);
        anim_trans_bottom_top.setStartOffset(400);
        anim_trans_left_right = AnimationUtils.loadAnimation(this,R.anim.translate_left_right);
        anim_trans_left_right.setStartOffset(3000);
        kids_a7adith_list = new ArrayList<>();
        Kids_A7adith_details hadith = new Kids_A7adith_details(R.drawable.back_educational_recycler);
        kids_a7adith_list.add(hadith);
        //delete
    /*    rv_kids_Adapter = new Recycler_Adapter_Kids_Mode(Kids_Activity.this ,kids_a7adith_list, new OnClickListener_A7adith_1level() {

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
        rv_a7adith_kids.setAdapter(rv_kids_Adapter);
        rv_a7adith_kids.setLayoutManager(new GridLayoutManager(Kids_Activity.this,2));
        */




     //   showDialog_7adith("قال رسول الله صلى الله عليه وسلم");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://hadith-pedia.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        API_interface api_interface = retrofit.create(API_interface.class);
        Call<Kids_json> call = api_interface.getChildHadith();

        call.enqueue(new Callback<Kids_json>() {
            @Override
            public void onResponse(Call<Kids_json> call, Response<Kids_json> response) {
                i=8;
                        list_kids_A7adith_images=new ArrayList<>();
        list_kids_A7adith_images.add(R.drawable.back_educational_recycler);   //????
        list_kids_A7adith_images.add(R.drawable.dialog_background);
            rv_kids_Adapter = new Recycler_Adapter_Kids_Mode(list_kids_A7adith_images, new OnClickListener_Kids() {
                @Override
                public void onClick(int position) {
   //           showDialog_7adith(response.body().getChildhadiths().get(position).getMatn(),response.body().getChildhadiths().get(position).getDescriptin(),
//           response.body().getChildhadiths().get(position).getAudioPath());
//                              response.body().getChildhadiths().get(position).getAudio());
                    //   showDialog_7adith("نص الحديث");
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                            rv_a7adith_kids.onVisibilityAggregated(false);
//                        }
//                          rv_kids_Adapter.notifyDataSetChanged();
                }
            });
                    rv_a7adith_kids.setAdapter(rv_kids_Adapter);

                  Toast.makeText(Kids_Activity.this,response.body().getChildhadiths().size()+" jjj"+i,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<Kids_json> call, Throwable t) {
            //    Toast.makeText(Kids_Activity.this,"false",Toast.LENGTH_LONG).show();
            }
     });
        rv_a7adith_kids.setLayoutManager(new LinearLayoutManager(Kids_Activity.this));
        Toast.makeText(Kids_Activity.this," jjj"+i,Toast.LENGTH_LONG).show();
    }


    //  public  void showDialog_7adith(String matn , String word_7adith , String synonym_word , String audio){

   public  void showDialog_7adith(String matn , String description , String audio) {
        rv_a7adith_kids.setVisibility(View.INVISIBLE);
       Dialog dialog = new Dialog(this);
       dialog.setContentView(R.layout.custom_dialog_kids_7adith);
       dialog.setCanceledOnTouchOutside(false);
       dialog.setCancelable(false);
       dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
       dialog.getWindow().setWindowAnimations(R.style.AnimationsForDialog);
       // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
       dialog.setCancelable(false);
       dialog.setCanceledOnTouchOutside(false);
       ImageView btn_close = dialog.findViewById(R.id.img_close_7adith);
       TextView tv_kids_matn_7adith = dialog.findViewById(R.id.tv_kids_matn_7adith);
       tv_kids_matn_7adith.setAnimation(anim_trans_fade_in);
       tv_kids_matn_7adith.setText(matn);
       TextView tv_word_7adith = dialog.findViewById(R.id.tv_Word_7adith);
       tv_word_7adith.setAnimation(anim_trans_bottom_top);
       tv_word_7adith.setText(description);
       TextView tv_synonymous_7adith = dialog.findViewById(R.id.tv_synonymous_7adith);
       tv_synonymous_7adith.setAnimation(anim_trans_left_right);
      img_play_7adith = dialog.findViewById(R.id.img_play_7adith);
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
           }

       private void   playAudio(String audio) {

//           if(!mediaPlayer.isPlaying()) {
//               mediaPlayer.start();
//            //   img_play_7adith.setImageResource(R.drawable.ic_baseline_play_arrow_24);
//           }else{
//             mediaPlayer.pause();
//           //  img_play_7adith.setImageResource(R.drawable.ic_baseline_pause_24);
//           }
           mediaPlayer = new MediaPlayer();
           mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
           try {
               mediaPlayer.setDataSource(audio);
               mediaPlayer.prepareAsync();
               mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                   @Override
                   public void onPrepared(MediaPlayer mediaPlayer) {
                       Toast.makeText(Kids_Activity.this, "true", Toast.LENGTH_LONG).show();
                   }
               });
               //mediaPlayer.start();
           } catch (IOException e){
               e.printStackTrace();
           }
          // Toast.makeText(Kids_Activity.this, "played", Toast.LENGTH_LONG).show();
       }

   }


/* test animation , then delete , dialog is right
    public  void showDialog_7adith(String matn){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_kids_7adith);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
        dialog.getWindow().setWindowAnimations(R.style.AnimationsForDialog);
        // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        ImageView btn_close = dialog.findViewById(R.id.img_close_7adith);
        TextView tv_kids_7adith = dialog.findViewById(R.id.tv_kids_matn_7adith);
        tv_kids_7adith.setAnimation(anim_trans_fade_in);
        ImageView img_play_7adith = dialog.findViewById(R.id.img_play_7adith);
        TextView tv_word_7adith = dialog.findViewById(R.id.tv_Word_7adith);
        tv_word_7adith.setAnimation(anim_trans_bottom_top);
       // tv_word_7adith.animate().setStartDelay(7000);
        TextView tv_synonymous_7adith = dialog.findViewById(R.id.tv_synonymous_7adith);
        tv_synonymous_7adith.setAnimation(anim_trans_left_right);
        // ImageView img_replay_7adith = dialog.findViewById(R.id.img_replay_7adith);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();}
        */
