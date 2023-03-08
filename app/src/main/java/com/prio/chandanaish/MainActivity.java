package com.prio.chandanaish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;
    LinearLayout webview;
    ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;
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
        mAdView = findViewById(R.id.adView);


        //ad
        marq.setSelected(true);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//        loadFullScreenad();



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

        temparature.setOnClickListener(view -> {
//                mInterstitialAd.show(MainActivity.this);
            Web.url="https://justweather.org/Bangladesh/Chittagong/Chittagong/Chandanaish/Hourly/";
            Intent intent= new Intent(getApplicationContext(), Web.class);
            startActivity(intent);

        });
        resultlist.setOnClickListener(view -> {
            Web.url ="https://sresult.bise-ctg.gov.bd/individual/";
            Intent intent= new Intent(getApplicationContext(), Web.class);
            startActivity(intent);
        });
        newslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mInterstitialAd.show(MainActivity.this);
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
        visitedplacelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="visitedplace";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","visitedplace");
                startActivity(intent);
            }
        });
        famouslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList.role="famousman";
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                intent.putExtra("key","famousman");
                startActivity(intent);

            }
        });

    }
    private  void loadFullScreenad(){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        InterstitialAd.load(this,"ca-app-pub-3186033098717337/2130752975", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.

                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.

                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.

                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

    }

}