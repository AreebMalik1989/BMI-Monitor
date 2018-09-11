package com.example.areebmalik1989.bmimonitor.view.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.view.fragment.BmiFragment;
import com.example.areebmalik1989.bmimonitor.view.fragment.StatsFragment;

/**
 * Created by areeb on 27/7/18.
 */

public class MyFragmentManager {

    private FragmentManager fragmentManager;
    private int contentFrameId;

    private Fragment bmiFragment;
    private Fragment statsFragment;

    public MyFragmentManager(AppCompatActivity activity, int contentFrameId){
        this.fragmentManager = activity.getSupportFragmentManager();
        this.contentFrameId = contentFrameId;

        bmiFragment = new BmiFragment();
        statsFragment = new StatsFragment();
    }

    public void updateFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(contentFrameId, fragment).commit();
    }

    public void switchFragments(String s){

        switch (s){

            case "Calculator":
                updateFragment(bmiFragment);
                break;

            case "Stats":
                updateFragment(statsFragment);
                break;
        }
    }

    public Fragment getBmiFragment(){
        return bmiFragment;
    }
}
