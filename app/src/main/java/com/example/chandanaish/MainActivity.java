package com.example.chandanaish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ImageView temparature;
    TextView marq ,dateTime;
    private MeowBottomNavigation meowBottomNavigation;
    ImageSlider imageSlider;
    ArrayList<SlideModel> imageList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temparature = findViewById(R.id.temparature);
        marq = findViewById(R.id.marqueetext);
        imageSlider =findViewById(R.id.image_slider);
        dateTime= findViewById(R.id.dateandtime);
        meowBottomNavigation=findViewById(R.id.bottomnavigation);

        marq.setSelected(true);


//slider image list
        imageList.add(new SlideModel(R.drawable.download,null));
        imageList.add(new SlideModel(R.drawable.download,null));
        imageList.add(new SlideModel(R.drawable.download,null));

        imageSlider.setImageList(imageList);

        //top bar date and time
//        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
//        dateTime.setText(currentDateTimeString);
        meowBottomNavigation.show(1,true);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_add_circle_24));

        temparature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Web.url="https://justweather.org/Bangladesh/Chittagong/Chittagong/Chandanaish/Hourly/";
                Intent intent= new Intent(getApplicationContext(), Web.class);
                startActivity(intent);

            }
        });

    }
}