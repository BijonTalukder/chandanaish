package com.prio.chandanaish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

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
        String userName;

        if (extras != null) {
            userName = extras.getString("key");
            switch (userName)
            {
                case "news":
                    Toast.makeText(ItemList.this, userName,
                            Toast.LENGTH_LONG).show();
                    MyAdapter adapter6 = new MyAdapter();
                    listView.setAdapter(adapter6);
                    hashMap = new HashMap<>();
                    hashMap.put("link","https://www.prothomalo.com/");
                    arrayList.add(hashMap);
                    hashMap = new HashMap<>();
                    hashMap.put("link","https://ajkalerkhobor.net/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://www.dailynayadiganta.com/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://www.daily-sun.com/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://www.bhorerkagoj.com/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://sangbad.net.bd/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://mzamin.com/");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link"," https://bartamanpatrika.com/home");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("link","https://www.ittefaq.com.bd/");
                    arrayList.add(hashMap);
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
                    hashMap.put("number","01968889965");
                    arrayList.add(hashMap);

                    break;
                case "hospital":
                    Toast.makeText(ItemList.this, userName,
                            Toast.LENGTH_LONG).show();
                    MyAdapter adapter2 = new MyAdapter();
                    listView.setAdapter(adapter2);


                    hashMap=new HashMap<>();
                    hashMap.put("name","BGC Trust Medical College");
                    hashMap.put("number","01832166950");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","Chandanaish Upazila Health Comple");
                    hashMap.put("number"," 01730-324446");
                    arrayList.add(hashMap);
                    break;
                case "police":
                    Toast.makeText(ItemList.this, userName,Toast.LENGTH_LONG).show();
                    MyAdapter adapter3 = new MyAdapter();
                    listView.setAdapter(adapter3);
                    hashMap= new HashMap<>();
                    hashMap.put("name","মো: ফয়েজ উদ্দিন");
                    hashMap.put("number","০১৬৩১৭৪০৫২১");
                    hashMap.put("status"," কনাস্টেবল");
                    arrayList.add(hashMap);
                    hashMap= new HashMap<>();
                    hashMap.put("name","আফছানা আক্তার");
                    hashMap.put("number","০১৭১৫৭২৭২৪৩");
                    hashMap.put("status","নারী কনাস্টেবল/২৭৬৬");
                    arrayList.add(hashMap);
                    hashMap= new HashMap<>();
                    hashMap.put("name","\tমোঃ আনোয়ার হোসেন");
                    hashMap.put("number","০১৮৮৭৭৬৪২৫০");
                    hashMap.put("status","কনাস্টেবল");
                    arrayList.add(hashMap);
                    hashMap= new HashMap<>();
                    hashMap.put("name","অংচি প্রু মারমা");
                    hashMap.put("number","০১৭৩৬৯৮৮৭১৬");
                    hashMap.put("status","কনাস্টেবল");
                    arrayList.add(hashMap);
                    hashMap= new HashMap<>();
                    hashMap.put("name","\tম্রা থোয়াই");
                    hashMap.put("number","০১৮৪০১৬৬১৩৯");
                    hashMap.put("status","কনাস্টেবল");
                    arrayList.add(hashMap);
                    hashMap= new HashMap<>();
                    hashMap.put("name","ছোটন চন্দ্র দাস");
                    hashMap.put("number","০১৮৭৬৭১২৯১০");
                    hashMap.put("status","এএসআই(নিঃ)");
                    arrayList.add(hashMap);

                    break;
                case "emargency":
                    Toast.makeText(ItemList.this, userName,Toast.LENGTH_LONG).show();
                    MyAdapter adapter4 = new MyAdapter();
                    listView.setAdapter(adapter4);
                    hashMap=new HashMap<>();
                    hashMap.put("name","ন্যাশনাল ইমার্জেন্সি সার্ভিস ");
                    hashMap.put("number","999");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","সরকারী তথ্য সেন্টার");
                    hashMap.put("number","333");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","কৃষি কল সেন্টার ");
                    hashMap.put("number","16123");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","\tজাতীয় মহিলা সংস্থার তথ্য আপাকে জিজ্ঞাসা");
                    hashMap.put("number","10922");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","প্রবাসীদের-জন্য-কল-সেন্টার");
                    hashMap.put("number","+8809610102030");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","নারী ও শিশু নির্যাতন প্রতিরোধ ");
                    hashMap.put("number","109");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","দুদক");
                    hashMap.put("number","106");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","দুর্যোগের আগাম বার্তা ");
                    hashMap.put("number","1090");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","ভুমি সেবা ");
                    hashMap.put("number","16122");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","ফায়ার সার্ভিস");
                    hashMap.put("number","16163");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","মাদক দ্রব্য নিয়ন্ত্রন");
                    hashMap.put("number","01908888888");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","ন্যাশনাল ইমার্জেন্সি সার্ভিস ");
                    hashMap.put("number","999");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name"," অ্যাম্বুলেন্স ");
                    hashMap.put("number","16263");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","\tবিটিসিএল কল সেন্টার");
                    hashMap.put("number","16402");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","কৃষি কল সেন্টার ");
                    hashMap.put("number","16123");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","সুখী পরিবার কল সেন্টার ");
                    hashMap.put("number","16767");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","সরকারি আইনগত সহায়তা");
                    hashMap.put("number","16430");
                    arrayList.add(hashMap);

                 break;
                case "postcode":
                    Toast.makeText(ItemList.this, userName,
                            Toast.LENGTH_LONG).show();
                    MyAdapter adapter5 = new MyAdapter();
                    listView.setAdapter(adapter5);
                    hashMap=new HashMap<>();
                    hashMap.put("name","Barama");
                    hashMap.put("code","4383");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","Barkal");
                    hashMap.put("code","4383");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","Bhailtali");
                    hashMap.put("code","4383");
                    arrayList.add(hashMap);
                    hashMap=new HashMap<>();
                    hashMap.put("name","Dhopachari");
                    hashMap.put("code","4381");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","Dohazari");
                    hashMap.put("code","4382");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","Hashimpur");
                    hashMap.put("code","4381");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","Joara");
                    hashMap.put("code","4380");
                    arrayList.add(hashMap);

                    hashMap=new HashMap<>();
                    hashMap.put("name","Kanchanabad");
                    hashMap.put("code","4381");
                    arrayList.add(hashMap);


                    hashMap=new HashMap<>();
                    hashMap.put("name","Satbaria");
                    hashMap.put("code","4383");
                    arrayList.add(hashMap);
                    break;
                case "doctor":
                    Toast.makeText(ItemList.this,"ধন্যবাদ আপনি এখন ডাক্তার এর লিস্ট দেখতে পাবেন",Toast.LENGTH_SHORT).show();
                    MyAdapter adapter7 = new MyAdapter();
                    listView.setAdapter(adapter7);
                    hashMap = new HashMap<>();
                    hashMap.put("name","ডা: বিপ্লব ভট্টাচার্য্য");
                    hashMap.put("designation","জুনিয়র কনসালটেন্ট");
                    hashMap.put("special","কার্ডিওলজি");
                    hashMap.put("camber","");
                    hashMap.put("visitingtime","");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডাঃ মোঃ মোস্তাফিজুর রহমান");
                    hashMap.put("designation","এম বি বি এস(চমেক),বিসিএস(স্বাস্থ্য),কার্ডেওলজি(চমেক)");
                    hashMap.put("special","হৃদরোগ ও মেডিসিন বিশেষজ্ঞ");
                    hashMap.put("camber","গ্রীন হাসপাতাল");
                    hashMap.put("visitingtime","সোমবার দুপুর ১২-২ টা ");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডাঃ রবিউল আলম");
                    hashMap.put("designation","এম বি বি এস(ডিএমসি),বিসিএস(স্বাস্থ্য),এফসিপিএস(মেডিসিন)");
                    hashMap.put("special","বাতরোগ ও মেডিসিন বিশেষজ্ঞ");
                    hashMap.put("camber","গ্রীন হাসপাতাল");
                    hashMap.put("visitingtime","প্রতি সোমবার");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডাঃ কানিজ নার্সমি আক্তার");
                    hashMap.put("designation","এমবিবিএস,এফ বি বিএস(গাইনী & অবস)");
                    hashMap.put("special","গাইনি বিশেষজ্ঞ");
                    hashMap.put("camber","গ্রীন হাসপাতাল");
                    hashMap.put("visitingtime","শুক্র,শনি,সোম,বুধ সন্ধ্যা ৬-৯ টা");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডাঃ মতিন");
                    hashMap.put("designation","");
                    hashMap.put("special","মেডিসিন বিশেষজ্ঞ");
                    hashMap.put("camber","আমরা কমিউনিটি হাসপাতাল");
                    hashMap.put("visitingtime","সোম থেকে শুক্র");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডা: শাহীন হোসায়ন");
                    hashMap.put("designation","আবাসিক মেডিকেল অফিসার");
                    hashMap.put("special","");
                    hashMap.put("camber","চন্দনাইশ মেডিক্যাল");
                    hashMap.put("visitingtime","");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","ডা: তাজিন সুলতানা");
                    hashMap.put("designation","জুনিয়র কনসালটেন্ট");
                    hashMap.put("special","গাঈনী");
                    hashMap.put("camber","চন্দনাইশ মেডিক্যাল");
                    hashMap.put("visitingtime","");
                    arrayList.add(hashMap);

                    break;
                case "visitedplace":
                    Toast.makeText(ItemList.this, userName,Toast.LENGTH_LONG).show();
                    MyAdapter adapter8 = new MyAdapter();
                    listView.setAdapter(adapter8);

                    hashMap = new HashMap<>();
                    hashMap.put("name","শুক্লাম্বর দীঘি");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);


                    hashMap = new HashMap<>();
                    hashMap.put("name","বিজিসি ট্রাস্ট বিশ্ববিদ্যালয় বাংলাদেশ লেক ও বিজিসি বিদ্যানগর এলাকা");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);


                    hashMap = new HashMap<>();
                    hashMap.put("name","দুধপুকুরিয়া-ধোপাছড়ি বন্যপ্রাণ অভয়ারণ্য");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);



                    hashMap = new HashMap<>();
                    hashMap.put("name","চা বাগান, কাঞ্চনাবাদ");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);



                    hashMap = new HashMap<>();
                    hashMap.put("name","বৈলতলী সাঙ্গু নদী");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);


                    hashMap = new HashMap<>();
                    hashMap.put("name","জামিরজুরী বধ্যভূমি");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);



                    hashMap = new HashMap<>();
                    hashMap.put("name","হযরত ভূঁই খাজা জামে মসজিদ");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);

                    hashMap = new HashMap<>();
                    hashMap.put("name","সাতবাড়িয়া শান্তি বিহার");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);



                    hashMap = new HashMap<>();
                    hashMap.put("name","বুড়ি কালি মন্দির, বরমা");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);


                    hashMap = new HashMap<>();
                    hashMap.put("name","নবরত্ন বিহার, সাতবাড়িয়া");
                    hashMap.put("description","");
                    hashMap.put("","কার্ডিওলজি");
                    arrayList.add(hashMap);

//
//                    hashMap = new HashMap<>();
//                    hashMap.put("name","শুক্লাম্বর দীঘি");
//                    hashMap.put("description","");
//                    hashMap.put("","কার্ডিওলজি");
//                    arrayList.add(hashMap);
//
//
//                    hashMap = new HashMap<>();
//                    hashMap.put("name","শুক্লাম্বর দীঘি");
//                    hashMap.put("description","");
//                    hashMap.put("","কার্ডিওলজি");
//                    arrayList.add(hashMap);
                    break;
                case "famousman":
                    Toast.makeText(ItemList.this, userName,Toast.LENGTH_LONG).show();
                    MyAdapter adapter9 = new MyAdapter();
                    listView.setAdapter(adapter9);
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
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);



            switch (role)
            {

                case "education":
                    LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view1 = layoutInflater.inflate(R.layout.demo_list_view,viewGroup,false);
                    view1.setAnimation(animation);
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
                    view2.setAnimation(animation);
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
                            dialIntent.setData(Uri.parse(String.format("tel:%s", fireservicenumbervalue)));
                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            startActivity(dialIntent );
//
                        }
                    });
                 return view2;
                case "hospital":
                    LayoutInflater layoutInflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    View view3 = layoutInflater2.inflate(R.layout.demo_list_view_call,viewGroup,false);
                    view3.setAnimation(animation);
                    HashMap<String,String> hashMap2 = arrayList.get(i);
                    TextView hospitalservicename = view3.findViewById(R.id.textitemdemo1);
                    TextView hospitalservicenumber = view3.findViewById(R.id.number);
                    String hospitalervicenamevalue = hashMap2.get("name");
                    String hospitalservicenumbervalue = hashMap2.get("number");
                    hospitalservicename.setText(hospitalervicenamevalue);
                    hospitalservicenumber.setText(hospitalservicenumbervalue);
                    LinearLayout linearLayout1 = view3.findViewById(R.id.demolistwithcall);
                    linearLayout1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                            dialIntent.setData(Uri.parse(String.format("tel:%s", hospitalservicenumbervalue)));
                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            startActivity(dialIntent );
                        }
                    });
                    return view3;
                case "police":
                    LayoutInflater layoutInflater3 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view4 = layoutInflater3.inflate(R.layout.layoutwithuserandcall,viewGroup,false);
                    view4.setAnimation(animation);
                    HashMap<String,String> hashMap3 = arrayList.get(i);
                    TextView policename = view4.findViewById(R.id.nameofman);
                    TextView policenumber = view4.findViewById(R.id.number);
                    TextView status=view4.findViewById(R.id.status);
                    String policenamevalue = hashMap3.get("name");
                    String policenumbervalue = hashMap3.get("number");
                    String policestatusvalue = hashMap3.get("status");
                    policename.setText(policenamevalue);
                    policenumber.setText(policenumbervalue);
                    status.setText(policestatusvalue);
                    LinearLayout linearLayout2 = view4.findViewById(R.id.listuser);
                    linearLayout2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                            dialIntent.setData(Uri.parse(String.format("tel:%s", policenumbervalue)));
                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            startActivity(dialIntent );

                        }
                    });
                    return  view4;
                case "emargency":
                    LayoutInflater layoutInflater4 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view5 = layoutInflater4.inflate(R.layout.demo_list_view_call,viewGroup,false);
                    view5.setAnimation(animation);
                    HashMap<String,String> hashMap4 = arrayList.get(i);
                    TextView emargencyservicename = view5.findViewById(R.id.textitemdemo1);
                    TextView emargencyservicenumber = view5.findViewById(R.id.number);
                    String emargencylservicenamevalue = hashMap4.get("name");
                    String emargencyservicenumbervalue = hashMap4.get("number");
                    emargencyservicename.setText(emargencylservicenamevalue);
                    emargencyservicenumber.setText(emargencyservicenumbervalue);
                    LinearLayout linearLayout3 = view5.findViewById(R.id.demolistwithcall);
                    linearLayout3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                            dialIntent.setData(Uri.parse(String.format("tel:%s",emargencyservicenumbervalue )));
                            Toast.makeText(ItemList.this,"call",Toast.LENGTH_SHORT).show();
                            startActivity(dialIntent );
                        }
                    });
                    return view5;
                case "postcode":
                    LayoutInflater layoutInflater5 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view6 = layoutInflater5.inflate(R.layout.demo_list_view,viewGroup,false);
                    view6.startAnimation(animation);
                    HashMap<String,String> hashMap5 = arrayList.get(i);
                    TextView postname = view6.findViewById(R.id.textitemdemo);
                    TextView code = view6.findViewById(R.id.eiin);
                    String postnamevalue = hashMap5.get("name");
                    String postcodevalue = hashMap5.get("code");
                    postname.setText(postnamevalue);
                    code.setText("CODE : "+postcodevalue);
                    return  view6;
                case "news":
                    LayoutInflater layoutInflater6= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view7 = layoutInflater6.inflate(R.layout.demoimage,viewGroup,false);
                    view7.setAnimation(animation);
                    HashMap<String,String> hashMap6 = arrayList.get(i);
                    ImageView newsImage = view7.findViewById(R.id.demoimageimageview);
                    newsImage.setImageResource(flag[i]);
                    String urlLink= hashMap6.get("link");
                    newsImage.setOnClickListener(view8 -> {
                        Web.url=urlLink;
                        Intent intent= new Intent(getApplicationContext(), Web.class);
                        startActivity(intent);


                    });

                    return view7;
                case "doctor":
                    LayoutInflater layoutInflater7 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view8 = layoutInflater7.inflate(R.layout.doctordemolist,viewGroup,false);
                    view8.startAnimation(animation);
                    HashMap<String,String> hashMap7 = arrayList.get(i);
                    TextView DoctorName = view8.findViewById(R.id.doctorName);
                    TextView DoctorDesignation = view8.findViewById(R.id.doctordesignation);
                    TextView DoctorSpeciality = view8.findViewById(R.id.spacalist);
                    TextView DoctorCamber= view8.findViewById(R.id.doctorcember);
                    TextView visitingTime = view8.findViewById(R.id.doctorvisitingtime);
                    String doctorNamevalue = hashMap7.get("name");
                    String designationvalue= hashMap7.get("designation");
                    String specialityvalue= hashMap7.get("special");
                    String cambervalue= hashMap7.get("camber");
                    String visitingtimevalue= hashMap7.get("visitingtime");

                    //set value
                    DoctorName.setText(doctorNamevalue);
                    DoctorDesignation.setText(designationvalue);
                    DoctorSpeciality.setText(specialityvalue);
                    DoctorCamber.setText(cambervalue);
                    visitingTime.setText(visitingtimevalue);
                    return view8;




                default:
                    return null;
            }

//            imageView.setImageResource(flag[i]);


        }
    }


}

