package com.example.lap11799.mvvp.view;


import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lap11799.mvvp.R;
import com.example.lap11799.mvvp.model.Data;
import com.example.lap11799.mvvp.viewmodel.MyViewModel;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    private TextView title;
    private TextView description;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        button = findViewById(R.id.button);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.getDatas().observe(MainActivity.this,datas -> {
                    Data data = datas.get(new Random().nextInt(datas.size()));
                    title.setText(data.getTitle());
                    description.setText(data.getDescription());
                });
            }
        });

    }
}
