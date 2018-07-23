package com.example.lap11799.mvvp.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public MutableLiveData<List<Data>> getDatas(){
        final MutableLiveData<List<Data>> data = new MutableLiveData<>();
        RetrofitApi.getRetrofitInstance().create(RetrofitService.class).getAllData().enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
