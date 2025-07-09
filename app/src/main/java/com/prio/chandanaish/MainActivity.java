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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;
    //    LinearLayout webview;
    LinearLayout layoutone;
    //    ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;
    ImageView temparature;
    TextView marq ,dateTime,dateandtime, govtStatus, tempText, weatherCondition, prayerTime, marqueetext;
    RequestQueue requestQueue;
//     CardView newslist,educationlist,fireservicelist,doctorlist,bloodlist,hospitallist,policelist,
//             diagonesticlist,visitedplacelist,emagencynumberlst,resultlist,songotonlist,esebalist,
//             postcodelist,famouslist,garivaralist,history,secoundlaybtn,Play;
//    private MeowBottomNavigation meowBottomNavigation;
//    ImageSlider imageSlider;

//    ArrayList<SlideModel> imageList = new ArrayList<>();

    private RecyclerView recyclerViewMenu;
    private MenuAdapter menuAdapter;
    String weatherApiKey = "4c1871e1f93458111a0d7990715fbcd8";

    private List<Map<String, Object>> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        temparature = findViewById(R.id.temparature);
        marq = findViewById(R.id.marqueetext);

        dateTime= findViewById(R.id.dateandtime);

        layoutone= findViewById(R.id.mainlay);
        tempText = findViewById(R.id.tempText);
        weatherCondition = findViewById(R.id.weatherCondition);
        recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        requestQueue = Volley.newRequestQueue(this);
        loadWeather();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, // HTTP method
                "https://backend-eight-lake-96.vercel.app/api/v1/breaking-news", // URL (replace with your actual endpoint)
                null, // No parameters (or provide a JSONObject if needed)
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle the response here
                        try {
                            JSONArray dataArray = response.getJSONArray("data");
                            StringBuilder marqueeText = new StringBuilder();

                            for (int i = 0; i < dataArray.length(); i++) {
                                JSONObject newsItem = dataArray.getJSONObject(i);
                                marq.setSelected(true);  // Make sure this line is called after setting the text

                                // Extract the news title and content (or other fields as needed)
                                String newsTitle = newsItem.getString("newsTitle");
                                marqueeText.append(newsTitle).append(" ");
                            }
                            marq.setText(marqueeText.toString());

                            // Start the marquee effect
                            marq.setSelected(true);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors here
                        error.printStackTrace();
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jsonObjectRequest);












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

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {


            Toast.makeText(MainActivity.this, item.getItemId(), Toast.LENGTH_SHORT).show();

            int id = item.getItemId();
            if (id == R.id.home) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (id == R.id.spot) {
                Intent spotIntent = new Intent(this, Web.class);
                spotIntent.putExtra("url", "https://cms-bijontalukders-projects.vercel.app/tourist-spot");
                startActivity(spotIntent);
                return true;
            } else if (id == R.id.news) {
                Intent newsIntent = new Intent(this, Web.class);
                newsIntent.putExtra("url", "https://cms-bijontalukders-projects.vercel.app/news");
                startActivity(newsIntent);
                return true;
            } else {
                return false;
            }

        });























        //ad
        marq.setSelected(true);
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });

    }

    private void loadWeather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=" + weatherApiKey + "&units=metric";

        JsonObjectRequest weatherRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        Log.d("WeatherResponse", response.toString());
                        JSONObject main = response.getJSONObject("main");
                        Log.d("WeatherResponse", main.toString());

                        JSONArray weatherArr = response.getJSONArray("weather");
                        JSONObject weather = weatherArr.getJSONObject(0);

                        String temp = main.getString("temp") + "°C";
                        String condition = weather.getString("main");
                        Log.d("WeatherResponse", condition);

//                      Toast.makeText()
                        tempText.setText(temp);
                        weatherCondition.setText(condition);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("WeatherError", error.toString()));

        requestQueue.add(weatherRequest);
    }
//    private  void loadFullScreenad(){
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//
//        InterstitialAd.load(this,"ca-app-pub-3186033098717337/2130752975", adRequest,
//                new InterstitialAdLoadCallback() {
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // The mInterstitialAd reference will be null until
//                        // an ad is loaded.
//                        mInterstitialAd = interstitialAd;
//                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
//                            @Override
//                            public void onAdClicked() {
//
//                            }
//
//                            @Override
//                            public void onAdDismissedFullScreenContent() {
//                                // Called when ad is dismissed.
//                                // Set the ad reference to null so you don't show the ad a second time.
//
//                                mInterstitialAd = null;
//                            }
//
//                            @Override
//                            public void onAdFailedToShowFullScreenContent(AdError adError) {
//                                // Called when ad fails to show.
//
//                                mInterstitialAd = null;
//                            }
//
//                            @Override
//                            public void onAdImpression() {
//                                // Called when an impression is recorded for an ad.
//
//                            }
//
//                            @Override
//                            public void onAdShowedFullScreenContent() {
//                                // Called when ad is shown.
//
//                            }
//                        });
//
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//
//                        mInterstitialAd = null;
//                    }
//                });
//
//    }

}