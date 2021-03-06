package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.ui.fragment.FirstFragment;
import com.sunflower.mydemo.ui.fragment.SecendFragment;
import com.sunflower.mydemo.ui.fragment.ThreeFragment;

/**
 * create 2015/12/30
 * author xuefei
 */
public class TabHostDemoActivity extends AppCompatActivity {

    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mLayoutInflater = LayoutInflater.from(this);

        init();
    }

    private void init () {
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("page1").setIndicator(genTabNavView("page1", R.mipmap.ic_user_center_nomal)), FirstFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("page2").setIndicator(genTabNavView("page2",R.mipmap.ic_user_center_nomal)), SecendFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("page3").setIndicator(genTabNavView("page3",R.mipmap.ic_user_center_nomal)), ThreeFragment.class, null);
    }

    /**
     * 返回Tab标签的View
     * @param title   标签的title
     * @param image   标签用的图片资源
     * @return  view
     */
    protected View genTabNavView(String title, int image) {
        View _vTab = mLayoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView iv_icon = (ImageView) _vTab.findViewById(R.id.iv_icon);
        iv_icon.setImageResource(image);
        TextView text = (TextView) _vTab.findViewById(R.id.text);
        text.setText(title);
        return _vTab;
    }
}
