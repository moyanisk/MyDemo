package com.sunflower.mydemo.ui.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.ui.fragment.DrawerFragment;

public class DrawerLayoutDemoActivity extends AppCompatActivity {

    private DrawerLayout dl_drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_demo);

        init ();
    }

    private void init () {
        dl_drawerlayout = (DrawerLayout) findViewById(R.id.dl_drawerlayout);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_drawer,new DrawerFragment()).commit();




    }
}
