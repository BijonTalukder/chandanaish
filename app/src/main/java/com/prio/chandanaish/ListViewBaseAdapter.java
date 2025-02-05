package com.prio.chandanaish;


import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

      inflater=LayoutInflater.from(context);
      view=inflater.inflate(R.layout.demo_list_view,viewGroup,false);
        TextView Title= view.findViewById(R.id.textitemdemo);
        HashMap<String, String> itemData = dataList.get(i);
        Toast.makeText(context, itemData.get("title")+"list view call", Toast.LENGTH_SHORT).show();
       Title.setText(itemData.get("title"));
//        description.setText(itemData.get("description"));
//        phoneNumber.setText(itemData.get("phoneNumber"));
      return view;
    }
}
