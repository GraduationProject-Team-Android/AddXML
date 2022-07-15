package com.example.graduationproject;

import com.example.graduationproject.Test.API_Test.Get_Grades_json;
import com.example.graduationproject.Test.API_Test.Ahadith_Level_json;
import com.example.graduationproject.Test.API_Test.Post_Grade_json;
import com.example.graduationproject.Test.API_Test.Test_json;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_json;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_interface {
    @GET("hadithsQuestion/{id}")
  public Call<Test_json> getQuestion(@Header("Authorization") String auth , @Path("id") int hadith_id );

    @GET("ChildHadith")
  public Call<Kids_json>getChildHadith();

   @Headers("Accept: application/json")
    @GET("levelHadiths/{id}")
  public Call<Ahadith_Level_json> getAhadithLevel(@Header("Authorization") String auth , @Path("id") int levelId);

    @GET("grades/{userId}")    // get grade and level
   public Call<Get_Grades_json> getGrades(@Header("Authorization") String auth , @Path("userId") int userId);

   @POST("attachGrade/{userId}/{levelId}?")
  public Call<Post_Grade_json> postGrade(@Header("Authorization") String auth , @Path("userId") int userId , @Path("levelId") int levelId
   , @Query("grade")int grade);


}

//https://hadith-pedia.herokuapp.com/api/levelHadiths/Id