package com.sunflower.mydemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sunflower.mydemo.R;

/**
 * create 2015/12/30
 * author xuefei
 */
public class TabHostDemoActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init () {
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);



    }
}
