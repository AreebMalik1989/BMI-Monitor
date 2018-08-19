package com.example.areebmalik1989.bmimonitor.view.mainActivity;

import com.example.areebmalik1989.bmimonitor.view.activity.IMainActivity;
import com.example.areebmalik1989.bmimonitor.view.activity.MainActivity;

import org.junit.After;
import org.junit.Before;

public class MainActivityTest {

    IMainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = new MainActivity();
    }

    @After
    public void tearDown() throws Exception {
    }
}