package com.prio.chandanaish;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VolleyRequest {

    private static final String TAG = "VolleyRequest";

    // Generic method to handle different types of data
    public static void sendGetRequest(Context context, String url, final VolleyCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Log the response to see it in Logcat
                            Log.d(TAG, "Response: " + response.toString());
                           Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
                            // Extracting "data" array from response
                            JSONArray dataArray = response.getJSONArray("data");

                            List<Map<String, Object>> parsedData = new ArrayList<>();

                            for (int i = 0; i < dataArray.length(); i++) {
                                JSONObject item = dataArray.getJSONObject(i);

                                // Dynamically parse each field based on the keys
                                Map<String, Object> itemData = parseItem(item);

                                parsedData.add(itemData);
                            }

                            // Passing the list of items to callback to update the RecyclerView
                            callback.onSuccess(parsedData);

                        } catch (Exception e) {
                            Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
                            Log.e(TAG, "Error parsing response", e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        // Log any errors that occur during the request
                        Toast.makeText(context, "Network Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Error: " + error.toString());
                    }
                });

        // Add the request to the request queue
        Volley.newRequestQueue(context).add(request);
    }

    // Generic method to parse each item dynamically
    private static Map<String, Object> parseItem(JSONObject item) {
        Map<String, Object> parsedData = new HashMap<>();

        try {
            // Add fields dynamically
            parsedData.put("id", item.getString("id"));
            parsedData.put("title", item.getString("title"));
            parsedData.put("status", item.getBoolean("status"));
            parsedData.put("imageUrl", item.optString("imageUrl", ""));  // Default empty if no image
            parsedData.put("shortDescription", item.optString("shortDescription", ""));
            parsedData.put("description", item.optString("description", ""));
            parsedData.put("phoneNumber", item.optString("phoneNumber", ""));
            parsedData.put("type", item.optString("type", ""));
            parsedData.put("isClikableLink", item.optBoolean("isClikableLink", false)); // Default to false if missing
            parsedData.put("url", item.optString("url", ""));
            parsedData.put("isInternalUrl", item.optBoolean("isInternalUrl", false));


//                         String
//            shortDescription  String?
//            description       String?
//            phoneNumber       String?
//            type              String
//                        Boolean? @default(true)
//                isClikableLink Boolean @default(false)
//                url               String
//                isInternalUrl     Boolean
//                          String
//                dynamicFields     Json?



        } catch (Exception e) {
            Log.e(TAG, "Error parsing item: " + e.toString());
        }

        return parsedData;
    }

    // Callback interface to pass the parsed data to the caller
    public interface VolleyCallback {
        void onSuccess(List<Map<String, Object>> parsedData);
    }
}
