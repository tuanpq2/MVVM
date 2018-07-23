package com.example.lap11799.mvvp.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/v2/5b5143722e00006d065c1825")
    Call<List<Data>> getAllData();
}
