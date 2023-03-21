package com.prio.chandanaish;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerChatAdapter extends FragmentPagerAdapter {
    public ViewPagerChatAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ChatFragment();

        }
//        else if(position==1)
//        {
//            return new StatusFr
//        }
  else if(position==1){
      return new ABPositive();
        }
        else{
            return new ChatFragment();
        }

    }

    @Override
    public int getCount() {
        return 7;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "A+";
        }
        else if(position==1){
            return "B+";
        }
        else if(position==2)
            return "AB+";
        else if(position==3)
            return  "AB-";
        else if(position==4)
            return "O+";
        else if(position==5) return "A-";

        else{
            return  "B-";
        }
    }
}
