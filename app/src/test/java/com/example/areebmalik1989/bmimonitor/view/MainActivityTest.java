package com.example.areebmalik1989.bmimonitor.view;

import com.example.areebmalik1989.bmimonitor.view.activity.IMainActivityView;
import com.example.areebmalik1989.bmimonitor.view.activity.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainActivityTest {

    IMainActivityView mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = new MainActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCollectData(){
    }


}