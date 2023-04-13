package com.prio.chandanaish;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BlankFragment extends Fragment {

ListView listView;

ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     View view = inflater.inflate(R.layout.fragment_blank, container, false);
     listView = view.findViewById(R.id.fraglistview);
     CustomAdapter customAdapter = new CustomAdapter();
     listView.setAdapter(customAdapter);
     hashMap = new HashMap<>();
     hashMap.put("name","Bijon");
     arrayList.add(hashMap);
        return view;
    }
    private class CustomAdapter extends BaseAdapter {
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
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view2 = layoutInflater.inflate(R.layout.demo_list_view_call,viewGroup,false);
            TextView fireservicename = view2.findViewById(R.id.textitemdemo1);
            TextView fireservicenumber = view2.findViewById(R.id.number);
            HashMap<String,String> hashMap1 = arrayList.get(i);
            String fireservicenamevalue = hashMap1.get("name");
            fireservicename.setText(fireservicenamevalue);

            return view2;
        }
    }
}