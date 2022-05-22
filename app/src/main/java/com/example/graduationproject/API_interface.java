package com.example.graduationproject;

import com.example.graduationproject.Test.API_Test.Test_json;
import com.example.graduationproject.Kids_A7adith.API_kids.Kids_json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface API_interface {
    @GET("hadithQuestions")
    public Call<Test_json> getQuestion(@Header("Authorization") String auth );

    //@GET("ChildHadith")
  //  public Call<Kids_json>getChildHadith();
    @GET("ChildHadith")
    public Call<Kids_json>getChildHadith();
  //  public Call<Kids_json>getChildHadith(@Header("Authorization") String auth);  //auth??
}
