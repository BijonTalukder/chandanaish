package com.example.chandanaish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
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
     CardView newslist,educationlist,fireservicelist,doctorlist,bloodlist,hospitallist,policelist,
             diagonesticlist,visitedplacelist,emagencynumberlst,resultlist,songotonlist,esebalist,
             postcodelist,famouslist,garivaralist;
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
//

        newslist = findViewById(R.id.newsCard);
        educationlist = findViewById(R.id.education);
        fireservicelist = findViewById(R.id.fireservice);
        doctorlist = findViewById(R.id.doctor);
        bloodlist = findViewById(R.id.blood);
        hospitallist = findViewById(R.id.hospital);
        policelist = findViewById(R.id.police);
        diagonesticlist= findViewById(R.id.daigonestic);
        visitedplacelist = findViewById(R.id.dorshoniyostan);
        emagencynumberlst = findViewById(R.id.emargencynumber);
        resultlist = findViewById(R.id.result);
        songotonlist = findViewById(R.id.songgoton);
        esebalist = findViewById(R.id.eseba);
        postcodelist = findViewById(R.id.postcode);
        famouslist = findViewById(R.id.bikhatomanush);
        garivaralist=findViewById(R.id.garibara);

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
        newslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="news";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","news");
                startActivity(intent);
            }
        });
        educationlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="education";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","education");
                startActivity(intent);

            }
        });
        fireservicelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="fire";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","fire");
                startActivity(intent);

            }
        });
        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="doctor";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","doctor");
                startActivity(intent);

            }
        });
       bloodlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="blood";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","blood");
                startActivity(intent);

            }
        });
        hospitallist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="hospital";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","hospital");
                startActivity(intent);

            }
        });
        policelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="police";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","police");
                startActivity(intent);

            }
        });
        emagencynumberlst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 ItemList.role="emargency";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","emargency");
                startActivity(intent);

            }
        });
        postcodelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="postcode";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","postcode");
                startActivity(intent);

            }
        });

    }
}