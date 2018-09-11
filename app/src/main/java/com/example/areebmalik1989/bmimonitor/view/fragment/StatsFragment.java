package com.example.areebmalik1989.bmimonitor.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.areebmalik1989.bmimonitor.MainApp;
import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.repository.BmiRecord;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

public class StatsFragment extends Fragment {

    private View view;

    private Box<BmiRecord> bmiRecordBox;

    @BindView(R.id.all_stats_chart)
    LineChart allStatsChart;

    public StatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_stats, container, false);

        ButterKnife.bind(this, view);

        setupChart();

        return view;
    }

    private void setupChart(){
        // no description text
        allStatsChart.getDescription().setEnabled(false);

        // enable touch gestures
        allStatsChart.setTouchEnabled(true);

        allStatsChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        allStatsChart.setDragEnabled(true);
        allStatsChart.setScaleEnabled(true);
        allStatsChart.setDrawGridBackground(false);
        allStatsChart.setHighlightPerDragEnabled(true);

        // set an alternative background color
        allStatsChart.setBackgroundColor(Color.WHITE);
        allStatsChart.setViewPortOffsets(0f, 0f, 0f, 0f);

        // add data
        setData();
        allStatsChart.invalidate();

        // get the legend (only possible after setting data)
        Legend l = allStatsChart.getLegend();
        l.setEnabled(false);

        XAxis xAxis = allStatsChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.rgb(255, 192, 56));
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(1f); // one hour
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM yyyy");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                long millis = TimeUnit.DAYS.toMillis((long) value);
                return mFormat.format(new Date(millis));
            }
        });

        YAxis leftAxis = allStatsChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis.setDrawGridLines(false);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setYOffset(-9f);
        leftAxis.setTextColor(Color.rgb(255, 192, 56));

        YAxis rightAxis = allStatsChart.getAxisRight();
        rightAxis.setEnabled(false);
    }

    private void setData(){

        bmiRecordBox = MainApp.getBmiRecordBox();

        Query query = bmiRecordBox.query()
                .build();

        List<BmiRecord> bmiRecords = query.find();

        List<Entry> entries = new ArrayList<>();

        for(BmiRecord br : bmiRecords){
            entries.add(new Entry(
                    TimeUnit.MILLISECONDS.toDays(br.getDate().getTime()),
                    (float) br.getBmi()));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(entries, "BMI Records");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);

        // create a data object with the datasets
        LineData data = new LineData(set1);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(9f);

        // set data
        allStatsChart.setData(data);
    }
}
