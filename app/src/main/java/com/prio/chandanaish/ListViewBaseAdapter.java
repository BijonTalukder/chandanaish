package com.prio.chandanaish;


import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewBaseAdapter extends BaseAdapter {
    private ArrayList<HashMap<String,String>> dataList;
    private Context context;
    private LayoutInflater inflater;

    public ListViewBaseAdapter(Context context, ArrayList<HashMap<String, String>> dataList) {
        this.context = context;  // Initialize the context
        this.dataList = dataList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        Animation animation = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.fade_in);


        HashMap<String, String> itemData = dataList.get(i);
        String type = itemData.get("type");
        if (type != null && type.equals("sectionCardOne")) {
            inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.demo_list_view_call,viewGroup,false);

            TextView Title= view.findViewById(R.id.textView);
            TextView shortDescription= view.findViewById(R.id.textView1);
            TextView Description= view.findViewById(R.id.textView2);
            TextView call= view.findViewById(R.id.textView3);

            String title = itemData.get("title");
            String shortDescriptionText = itemData.get("shortDescription");
String descriptionText = itemData.get("description");
String phoneNumberText = itemData.get("phoneNumber");
if ( title != null) {
    Title.setText(title);
    Title.setVisibility(View.VISIBLE);
}
if (descriptionText != null) {
    Description.setText(descriptionText);
    Description.setVisibility(View.VISIBLE);
}
if (shortDescriptionText != null) {
    shortDescription.setText(shortDescriptionText);
    shortDescription.setVisibility(View.VISIBLE);
}


//            Title.setText(itemData.get("title"));
        }

        if (type != null && type.equals("sectionCardTwo")) {
            inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.demo_list_view_call,viewGroup,false);

            TextView Title= view.findViewById(R.id.textView);
            TextView shortDescription= view.findViewById(R.id.textView1);
            TextView Description= view.findViewById(R.id.textView2);
            TextView call= view.findViewById(R.id.textView3);
            LinearLayout callSection = view.findViewById(R.id.callSection);
            LinearLayout demolistwithcall = view.findViewById(R.id.demolistwithcall);
            callSection.setVisibility(View.VISIBLE);

            String title = itemData.get("title");
            String shortDescriptionText = itemData.get("shortDescription");
            String descriptionText = itemData.get("description");
            String phoneNumberText = itemData.get("phoneNumber");
            if ( title != null) {
                Title.setText(title);
                Title.setVisibility(View.VISIBLE);
            }
            if (descriptionText != null) {
                Description.setText(descriptionText);
                Description.setVisibility(View.VISIBLE);
            }
            if (shortDescriptionText != null) {
                shortDescription.setText(shortDescriptionText);
                shortDescription.setVisibility(View.VISIBLE);
            }
            if (phoneNumberText != null) {
                call.setText(phoneNumberText);
                call.setVisibility(View.VISIBLE);
            }
            demolistwithcall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                          dialIntent.setData(Uri.parse(String.format("tel:%s", phoneNumberText)));
//                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            context.startActivity(dialIntent);
                }
            });
        }



        if (type!=null && type.equals("sectionCardThree")){
            inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.demoimage,viewGroup,false);
            LinearLayout layout = view.findViewById(R.id.demoimageimageview);

            ImageView imageView= view.findViewById(R.id.demoimageimageview);
            String imageUrl = itemData.get("imageUrl");
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Picasso.get()
                        .load(imageUrl)
                        .fit()
                        .into(imageView);
            }
            String urlLink = itemData.get("url");

            layout.setOnClickListener(view8 -> {

                        Intent intent= new Intent(context, Web.class);
                        context.startActivity(intent);


                    });


        }



      return view;
    }
}
