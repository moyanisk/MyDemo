package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuefei on 2016/1/13.
 */
public class ViewPagerDemoActivity extends AppCompatActivity {

    private ViewPager vp_viewpager;
    private List<View> views;
    private static final int[] pics = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        init();
    }

    private void init() {
        vp_viewpager = (ViewPager) findViewById(R.id.vp_viewpager);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        views = new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);
            iv.setImageResource(pics[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            views.add(iv);
        }

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(views);
        vp_viewpager.setAdapter(adapter);
    }



}
