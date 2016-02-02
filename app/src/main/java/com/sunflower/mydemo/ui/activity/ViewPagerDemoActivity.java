package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sunflower.mydemo.R;

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

    private void init () {
        vp_viewpager = (ViewPager) findViewById(R.id.vp_viewpager);
        views = new ArrayList<View>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        for (int i=0; i<pics.length;i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);
            iv.setImageResource(pics[i]);
            views.add(iv);
        }

        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter(views);
        vp_viewpager.setAdapter(pagerAdapter);

    }


    class MyViewPagerAdapter extends PagerAdapter {

        private List<View> views;

        public MyViewPagerAdapter (List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            if (views != null) {
                return views.size();
            }
            return 0;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


}
