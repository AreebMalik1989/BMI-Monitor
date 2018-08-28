package com.example.areebmalik1989.bmimonitor.view.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.view.util.MyFragmentManager;

import java.util.HashMap;

import github.areebmalik1989.simplify_activities.AboutActivityManager;
import github.areebmalik1989.simplify_activities.Notifier;
import github.areebmalik1989.simplify_resources.SimplifyPackage;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private ActionBarDrawerToggle toggle;
    private MyFragmentManager myFragementManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationDrawer();

        myFragementManager = new MyFragmentManager(this, R.id.content_frame);
        myFragementManager.updateFragment(myFragementManager.bmiFragment);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        if(toggle != null){
            toggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if(toggle != null){
            toggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed(){
        View currentView = getCurrentFocus();
        if(currentView != null){
            currentView.clearFocus();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.about:

                launchAboutActivity();
                break;

            case R.id.credits:

                HashMap<String, String> licenceMap = new HashMap<>();
                licenceMap.put(getString(R.string.butterknife), getString(R.string.butterknife_licence));

                String title = getString(R.string.credits);

                Notifier notifier = new Notifier(this);
                notifier.showNotice(title, licenceMap);

                break;
        }

        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void setupNavigationDrawer(){

        final String[] menu;
        final DrawerLayout drawerLayout;
        final ListView listView;
        final ArrayAdapter<String> adapter;

        menu = getResources().getStringArray(R.array.fragments);
        drawerLayout = findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.left_drawer);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                drawerLayout.closeDrawers();

                myFragementManager.switchFragments(menu[position]);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(toggle);
    }

    private void launchAboutActivity(){

        PackageInfo packageInfo = SimplifyPackage.getPackageInfo(this);

        AboutActivityManager aboutActivityManager = new AboutActivityManager(MainActivity.this);
        aboutActivityManager.startActivity(getString(R.string.app_name),
                packageInfo.versionName, String.valueOf(packageInfo.versionCode),
                getString(R.string.areeb),
                getString(R.string.areeb_email),
                R.raw.web_hi_res_512);

    }
}
