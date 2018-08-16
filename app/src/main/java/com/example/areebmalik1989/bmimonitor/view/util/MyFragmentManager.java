package com.example.areebmalik1989.bmimonitor.view.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.areebmalik1989.bmimonitor.view.fragment.BmiFragment;

/**
 * Created by areeb on 27/7/18.
 */

public class MyFragmentManager {

    private FragmentManager fragmentManager;
    private int contentFrameId;

    public Fragment bmiFragment;

    public MyFragmentManager(AppCompatActivity activity, int contentFrameId){
        this.fragmentManager = activity.getSupportFragmentManager();
        this.contentFrameId = contentFrameId;

        bmiFragment = new BmiFragment();
    }

    public void updateFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(contentFrameId, fragment).commit();
    }

    public void switchFragments(String s){

        switch (s){

            case "BMI":
                this.updateFragment(bmiFragment);
                break;
        }
    }
}
