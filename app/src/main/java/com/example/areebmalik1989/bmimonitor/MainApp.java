package com.example.areebmalik1989.bmimonitor;

import android.app.Application;
import android.util.Log;

import com.example.areebmalik1989.bmimonitor.repository.BmiRecord;
import com.example.areebmalik1989.bmimonitor.repository.MyObjectBox;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class MainApp extends Application {

    private static BoxStore recordStore;
    private static Box<BmiRecord> bmiRecordBox;
    private static MainApp mainApp;

    @Override
    public void onCreate(){
        super.onCreate();

        mainApp = this;
        recordStore = MyObjectBox.builder().androidContext(MainApp.this).build();
        bmiRecordBox = recordStore.boxFor(BmiRecord.class);

        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(recordStore).start(this);
        }

        Log.d("MainApp", "Using ObjectBox " + BoxStore.getVersion() + " (" + BoxStore.getVersionNative() + ")");
    }

    public static MainApp getApp(){
        return mainApp;
    }

    public static Box<BmiRecord> getBmiRecordBox(){
        return bmiRecordBox;
    }
}
