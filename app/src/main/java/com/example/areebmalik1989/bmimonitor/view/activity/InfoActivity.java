package com.example.areebmalik1989.bmimonitor.view.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.opensource.NoticeActivityManager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends AppCompatActivity {

    @BindView(R.id.info_version)
    TextView version;

    @BindView(R.id.info_version_code)
    TextView versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ButterKnife.bind(this);

        PackageInfo packageInfo = null;

        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        version.setText(packageInfo.versionName);
        versionCode.setText(String.valueOf(packageInfo.versionCode));
    }

    @OnClick(R.id.credit_button)
    public void openCreditActivity(){

        HashMap<String, String> map = new HashMap<>();
        map.put(getString(R.string.butterknife), getString(R.string.butterknife_licence));

        String title = getString(R.string.credits);

        NoticeActivityManager noticeActivityManager = new NoticeActivityManager(this);
        noticeActivityManager.startNoticeActivity(title, map);
    }
}
