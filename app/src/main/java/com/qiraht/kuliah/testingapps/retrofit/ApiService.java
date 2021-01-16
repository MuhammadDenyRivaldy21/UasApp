package com.qiraht.kuliah.testingapps.retrofit;

import com.qiraht.kuliah.testingapps.model.MatchResult.ResponseResult;
import com.qiraht.kuliah.testingapps.model.MatchSchedule.ResponseSchedule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String BASE_URL = "https://thesportsdb.com/";

    @GET("api/v1/json/1/eventspastleague.php")
    Call<ResponseResult> getResult (
            @Query("id") String id
    );

    @GET("api/v1/json/1/eventsnextleague.php?")
    Call<ResponseSchedule> getSchedule (
            @Query("id") String id
    );
}
