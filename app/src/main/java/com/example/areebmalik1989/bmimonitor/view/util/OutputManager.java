package com.example.areebmalik1989.bmimonitor.view.util;

import android.graphics.Color;
import android.widget.TextView;

import com.example.areebmalik1989.arcprogress.ArcProgress;

public class OutputManager {

    ArcProgress progressBar;
    TextView textView;

    public OutputManager(ArcProgress progressBar, TextView textView){
        this.progressBar = progressBar;
        this.textView = textView;

        progressBar.setMax(40);
        progressBar.setTextSize(200);
    }

    public void setProgress(double progress){

        if(progress < 16) {
            progressBar.setFinishedStrokeColor(Color.rgb(0,255,255));
            textView.setTextColor(Color.rgb(0,255,255));
        } else if (progress < 17) {
            progressBar.setFinishedStrokeColor(Color.rgb(0,255,191));
            textView.setTextColor(Color.rgb(0,255,191));
        } else if (progress < 18.5) {
            progressBar.setFinishedStrokeColor(Color.rgb(0,255,128));
            textView.setTextColor(Color.rgb(0,255,128));
        } else if (progress < 25) {
            progressBar.setFinishedStrokeColor(Color.rgb(0, 255, 0));
            textView.setTextColor(Color.rgb(0, 255, 0));
        } else if (progress < 30) {
            progressBar.setFinishedStrokeColor(Color.rgb(255,191,0));
            textView.setTextColor(Color.rgb(255,191,0));
        } else if (progress < 35) {
            progressBar.setFinishedStrokeColor(Color.rgb(255, 128, 0));
            textView.setTextColor(Color.rgb(255, 128, 0));
        } else if (progress < 40) {
            progressBar.setFinishedStrokeColor(Color.rgb(255,64,0));
            textView.setTextColor(Color.rgb(255,64,0));
        } else if (progress >= 40) {
            progressBar.setFinishedStrokeColor(Color.rgb(255,0,0));
            textView.setTextColor(Color.rgb(255,0,0));
        }

        progressBar.setProgress((float)progress);
    }
}
