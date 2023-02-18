package com.example.chandanaish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemList extends AppCompatActivity {
    ListView listView;
    public static String role;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList();
    HashMap<String,String> hashMap;
   int[] flag={R.drawable.b1,R.drawable.b2,R.drawable.b3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        listView = findViewById(R.id.listview);
        Bundle extras = getIntent().getExtras();
        String userName;

        if (extras != null) {
            userName = extras.getString("key");
            switch (userName)
            {
                case "news":
                    Toast.makeText(ItemList.this, userName,
                        Toast.LENGTH_LONG).show();

                    break;



                    case "education":
                    Toast.makeText(ItemList.this, userName,
                            Toast.LENGTH_LONG).show();
                    MyAdapter adapter = new MyAdapter();
                    listView.setAdapter(adapter);
                    hashMap=new HashMap<>();
                    hashMap.put("name","BAILTALI MULTILA TERAL HIGH SCHOOL");
                    hashMap.put("EIIN","104163");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","BARAKAL ABDUL HIGH ANOWARA BEGUM GIRLS SCHOOL");
                    hashMap.put("EIIN","104180");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","BARAMA TRAHI MENAKA HIGH SCHOOL");
                    hashMap.put("EIIN","104171");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","BARKAL S.Z. HIGH SCHOOL");
                    hashMap.put("EIIN","104174");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","CHAMUDARIA UNITED INSTITUTE ML HIGH SCHOOL");
                    hashMap.put("EIIN","104175");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","DHOPACHARI SHIK GHATA HIGH SCHOOL");
                    hashMap.put("EIIN","131388");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","DIAKUL SANOWARA ADARSHA SCHOOL");
                    hashMap.put("EIIN","104160");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","DOHAZARI JAMIJURI A.RAHMAN HIGH SCHOOL");
                    hashMap.put("EIIN","104168");
                    arrayList.add(hashMap);


                    hashMap=new HashMap<>();
                    hashMap.put("name","GASBARIA MOMTAJ BEGUM GIRLS SCHOOL");
                    hashMap.put("EIIN","104179");
                    arrayList.add(hashMap);
                    break;
                case "fire":
                    Toast.makeText(ItemList.this, userName,
                            Toast.LENGTH_LONG).show();
                    MyAdapter adapter1 = new MyAdapter();
                    listView.setAdapter(adapter1);
                    hashMap=new HashMap<>();
                    hashMap.put("name","চন্দনাইশ ফায়ার সার্ভিস");
                    hashMap.put("number","+8801968889965");
                    arrayList.add(hashMap);

                    break;


                default:
                    Toast.makeText(ItemList.this, "toast",
                      Toast.LENGTH_LONG).show();
            }
//            if(userName=="news"){
//
//
//            }

            // and get whatever type user account id is
        }
    }


    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return arrayList.size();
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



            switch (role)
            {
                case "education":
                    LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view1 = layoutInflater.inflate(R.layout.demo_list_view,viewGroup,false);
//                    ImageView imageView= view1.findViewById(R.id.img);

                    TextView Title = view1.findViewById(R.id.textitemdemo);
                    TextView EIIN = view1.findViewById(R.id.eiin);
                    HashMap<String,String> hashMap = arrayList.get(i);
                    String name= hashMap.get("name");
                    String eiinValue= hashMap.get("EIIN");
                    Title.setText(name);
                    EIIN.setText("EIIN : "+eiinValue);
                    return view1;
                case "fire":
                    LayoutInflater layoutInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 View view2 = layoutInflater1.inflate(R.layout.demo_list_view_call,viewGroup,false);
                 TextView fireservicename = view2.findViewById(R.id.textitemdemo1);
                 TextView fireservicenumber = view2.findViewById(R.id.number);
                 HashMap<String,String> hashMap1 = arrayList.get(i);
                 String fireservicenamevalue = hashMap1.get("name");
                 String fireservicenumbervalue = hashMap1.get("number");
                 fireservicename.setText(fireservicenamevalue);
                 fireservicenumber.setText(fireservicenumbervalue);
                    LinearLayout linearLayout = view2.findViewById(R.id.demolistwithcall);
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            String.format("tel: %s",fireservicenumbervalue);
                            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                            dialIntent.setData(Uri.parse("tel:"+fireservicenamevalue));
                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            if (dialIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(dialIntent);
                            }
//                            else {
//                                Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
//                            }
                        }
                    });
                 return view2;

                default:
                    return null;
            }

//            imageView.setImageResource(flag[i]);


        }
    }


}

