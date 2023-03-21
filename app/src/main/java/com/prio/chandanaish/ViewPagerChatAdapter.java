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
        return 3;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "chats";
        }
        else if(position==1){
            return "Ab+";
        }
        else{
            return  "a";
        }
    }
}
