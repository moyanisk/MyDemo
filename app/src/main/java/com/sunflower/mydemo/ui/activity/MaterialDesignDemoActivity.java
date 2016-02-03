package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MaterialDesignDemoActivity extends AppCompatActivity {

    private List<View>  mViews;
    private String[] mTitles = {"Tab 1","Tab 2","Tab 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init () {
        //init tabs
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab());
        tabs.addTab(tabs.newTab());
        tabs.addTab(tabs.newTab());
        ViewPager vp_views = (ViewPager) findViewById(R.id.vp_views);
        mViews = new ArrayList<>();

        for (int i = 0; i<3 ; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.viewpager_cell, null);
            TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_content.setText(mTitles[i]);
            mViews.add(view);
        }

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(mViews, mTitles);
        vp_views.setAdapter(adapter);

        tabs.setupWithViewPager(vp_views);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG);
                snackbar.setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackbar.dismiss();
                            }
                        });
                snackbar.show();
            }
        });
        /*
        EditText et_editext = (EditText) findViewById(R.id.et_edittext);
        final TextInputLayout til = (TextInputLayout) findViewById(R.id.til);
        et_editext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 10) {
                    til.setError("Error");
                    til.setErrorEnabled(true);
                } else {
                    til.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });*/


    }



}
