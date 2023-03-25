package com.prio.chandanaish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


public class ABPositive extends Fragment {
    ListView l1;
ArrayList<HashMap<String,String>> arrayList = new ArrayList();
HashMap<String,String> hashMap;
    public ABPositive() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_b_positive, container, false);
        l1.findViewById(R.id.listabpositive);
        // Inflate the layout for this fragment
Myadapter1  myadapter1= new Myadapter1();
l1.setAdapter(myadapter1);

        return view;
    }
    private class Myadapter1  extends BaseAdapter {
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
            return null;
        }
    }
}