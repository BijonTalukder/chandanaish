package com.prio.chandanaish;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemList extends AppCompatActivity {
    ListView listView;
    public static String role;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList();
    HashMap<String,String> hashMap;
    int[] flag={R.drawable.b1,R.drawable.b2,R.drawable.b3,
            R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,
            R.drawable.b8,R.drawable.b32};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        listView = findViewById(R.id.listview);
        Bundle extras = getIntent().getExtras();
        String itemId = "";

        if (extras != null) {
            itemId = extras.getString("id", ""); // Default to empty if not found
        }


        // Construct API URL properly
        String apiUrl = "https://backend-eight-lake-96.vercel.app/api/v1/services-list/services/" + itemId;
//        Toast.makeText(this, apiUrl, Toast.LENGTH_LONG).show();
        VolleyRequest.sendGetRequest(ItemList.this, apiUrl, new VolleyRequest.VolleyCallback() {
            @Override
            public void onSuccess(List<Map<String, Object>> parsedData) {

                if (parsedData != null) {
                    for (Map<String, Object> data : parsedData) {
                        HashMap<String, String> hashMap = new HashMap<>();


                        hashMap.put("title", getSafeString(data, "title", "Unknown Title"));
                        hashMap.put("description", getSafeString(data, "description", "No Description"));
                        hashMap.put("shortDescription", getSafeString(data, "shortDescription", "No shortDescription"));

                        hashMap.put("phoneNumber", getSafeString(data, "phoneNumber", "No Phone"));
                        hashMap.put("type", getSafeString(data, "type", "N/A"));
                        hashMap.put("status", getSafeString(data, "status", "false"));
                        hashMap.put("isClikableLink", getSafeString(data, "isClikableLink", "false"));


                        hashMap.put("url", getSafeString(data, "url", ""));
                        hashMap.put("imageUrl", getSafeString(data, "imageUrl", ""));
                        arrayList.add(hashMap);
                    }
//
                    ListViewBaseAdapter adapter = new ListViewBaseAdapter(ItemList.this, arrayList);
                    listView.setAdapter(adapter);


                }
            }
        });

    }



    private String getSafeString(Map<String, Object> data, String key, String defaultValue) {
        if (data.containsKey(key) && data.get(key) != null) {
            return data.get(key).toString();
        } else {
            return defaultValue;  // Return the default value if the key is missing or value is null
        }
    }}
