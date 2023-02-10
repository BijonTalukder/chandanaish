package com.example.chandanaish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView temparature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temparature = findViewById(R.id.temparature);

        temparature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.url="https://justweather.org/Bangladesh/Chittagong/Chittagong/Chandanaish/Hourly/";


            }
        });
    }
}