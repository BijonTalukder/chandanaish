package com.prio.chandanaish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
//import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;
    LinearLayout webview;
    LinearLayout layoutone,layounttwo;
    ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;
    ImageView temparature;
    TextView marq ,dateTime;
     CardView newslist,educationlist,fireservicelist,doctorlist,bloodlist,hospitallist,policelist,
             diagonesticlist,visitedplacelist,emagencynumberlst,resultlist,songotonlist,esebalist,
             postcodelist,famouslist,garivaralist,history,secoundlaybtn,Play;
//    private MeowBottomNavigation meowBottomNavigation;
    ImageSlider imageSlider;

    ArrayList<SlideModel> imageList = new ArrayList<>();

    private RecyclerView recyclerViewMenu;
    private MenuAdapter menuAdapter;
    private List<Map<String, Object>> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temparature = findViewById(R.id.temparature);
        marq = findViewById(R.id.marqueetext);

        dateTime= findViewById(R.id.dateandtime);

        layoutone= findViewById(R.id.mainlay);

        recyclerViewMenu = findViewById(R.id.recyclerViewMenu);

// Initialize the menu list first
        menuItemList = new ArrayList<>();

// Pass the initialized list to the adapter
        menuAdapter = new MenuAdapter(this, menuItemList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return menuAdapter.getItemViewType(position) == MenuAdapter.TYPE_BANNER ? 4 : 1;
            }
        });
        recyclerViewMenu.setLayoutManager(gridLayoutManager);
        recyclerViewMenu.setAdapter(menuAdapter);

        String apiUrl = "https://backend-eight-lake-96.vercel.app/api/v1/services"; // Replace with your actual URL

        VolleyRequest.sendGetRequest(MainActivity.this, apiUrl, new VolleyRequest.VolleyCallback() {
            @Override
            public void onSuccess(List<Map<String, Object>> parsedData) {
                menuAdapter.updateMenuItems(parsedData);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

























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
//        imageList.add(new SlideModel(R.drawable.download,null));
//        imageList.add(new SlideModel(R.drawable.download,null));
//        imageList.add(new SlideModel(R.drawable.download,null));
//
//        imageSlider.setImageList(imageList);

        //top bar date and time
//        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
//        dateTime.setText(currentDateTimeString);
//        meowBottomNavigation.show(1,true);
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_add_circle_24));


//      meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//          @Override
//          public Unit invoke(MeowBottomNavigation.Model model) {
//              return null;
//          }
//      });
//      meowBottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//          @Override
//          public Unit invoke(MeowBottomNavigation.Model model) {
//              if (model.getId()==1){
//                  layoutone.setVisibility(View.VISIBLE);
//                  layounttwo.setVisibility(View.GONE);
//              }
//              else{
//                  layounttwo.setVisibility(View.VISIBLE);
//layoutone.setVisibility(View.GONE);
//              }
//              return null;
//          }
//      });

        temparature.setOnClickListener(view -> {
//                mInterstitialAd.show(MainActivity.this);
//            Web.url="https://justweather.org/Bangladesh/Chittagong/Chittagong/Chandanaish/Hourly/";
//            Intent intent= new Intent(getApplicationContext(), Web.class);
//            startActivity(intent);

        });
//        resultlist.setOnClickListener(view -> {
//            Web.url ="http://www.educationboardresults.gov.bd/";
//            Intent intent= new Intent(getApplicationContext(), Web.class);
//            startActivity(intent);
//        });
//        newslist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // mInterstitialAd.show(MainActivity.this);
//                ItemList.role="news";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","news");
//                startActivity(intent);
//            }
//        });
//        educationlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="education";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","education");
//                startActivity(intent);
//
//            }
//        });
//        fireservicelist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="fire";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","fire");
//                startActivity(intent);
//
//            }
//        });
//        doctorlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="doctor";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","doctor");
//                startActivity(intent);
//
//            }
//        });
//       bloodlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="blood";
//                Intent intent = new Intent(getApplicationContext(), Blood.class);
//                intent.putExtra("key","blood");
//                startActivity(intent);
//
//            }
//        });
//        hospitallist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="hospital";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","hospital");
//                startActivity(intent);
//
//            }
//        });
//        policelist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="police";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","police");
//                startActivity(intent);
//
//            }
//        });
//        emagencynumberlst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 ItemList.role="emargency";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","emargency");
//                startActivity(intent);
//
//            }
//        });
//        postcodelist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="postcode";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","postcode");
//                startActivity(intent);
//
//            }
//        });
//        visitedplacelist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="visitedplace";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","visitedplace");
//                startActivity(intent);
//            }
//        });
//        famouslist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="famousman";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","famousman");
//                startActivity(intent);
//
//            }
//        });
//        esebalist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ItemList.role="dokan";
//                Intent intent = new Intent(getApplicationContext(), ItemList.class);
//                intent.putExtra("key","dokan");
//                startActivity(intent);
//
//            }
//        });
//        history.setOnClickListener(view -> {
//            Intent intent = new Intent(this,itihash.class);
//            startActivity(intent);
//        });


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