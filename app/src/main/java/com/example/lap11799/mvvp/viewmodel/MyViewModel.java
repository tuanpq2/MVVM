package com.example.lap11799.mvvp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.lap11799.mvvp.model.Data;
import com.example.lap11799.mvvp.model.Repository;

import java.util.List;
import java.util.Random;

public class MyViewModel extends AndroidViewModel{

    private Repository repository;
    private MutableLiveData<List<Data>> datas;

    public MyViewModel(@NonNull Application application){
        super(application);
        this.repository = new Repository();
    }

    public LiveData<List<Data>> getDatas(){
        if(datas == null) {
            datas = repository.getDatas();
        }
        return datas;
    }
}