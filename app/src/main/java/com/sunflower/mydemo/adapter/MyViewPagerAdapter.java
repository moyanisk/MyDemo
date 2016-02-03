package com.sunflower.mydemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xuefei on 2016/2/3.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> mViews;
    private String[] mTitiles;

    public MyViewPagerAdapter(List<View> _views) {
        mViews = _views;
    }

    public MyViewPagerAdapter(List<View> _views, String[] _titles) {
        mViews = _views;
        mTitiles = _titles;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        if (mViews != null) {
            return mViews.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitiles[position];
    }
}