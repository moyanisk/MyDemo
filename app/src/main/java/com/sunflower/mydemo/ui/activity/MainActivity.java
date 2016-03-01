package com.sunflower.mydemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.model.ActivityInfo;

import java.util.Arrays;
import java.util.List;

/**
 * create 2015/12/30
 * author xuefei
 */
public class MainActivity extends AppCompatActivity {

    private List<ActivityInfo> mData = Arrays.asList(
            new ActivityInfo("Tab Host", TabHostDemoActivity.class),
            new ActivityInfo("Volley", VolleyDemoActivity.class),
            new ActivityInfo("DrawerLayout Demo", DrawerLayoutDemoActivity.class),
            new ActivityInfo("Bitmap", BitmapCompressDemoActivity.class),
            new ActivityInfo("ViewPager", ViewPagerDemoActivity.class),
            new ActivityInfo("Material Design", MaterialDesignDemoActivity.class),
            new ActivityInfo("Service Demo", ServiceDemoActivity.class),
            new ActivityInfo("悬浮框设计", FloatViewActivity.class),
            new ActivityInfo("Toast示例", ToastShowActivity.class)
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        init();
    }


    /**
     * 初始化
     */
    private void init() {
        String[] datas = getResources().getStringArray(R.array.model_name);
        ListView lv_listview = (ListView) findViewById(R.id.lv_listview);
        ArrayAdapter<ActivityInfo> arrayAdapter = new ArrayAdapter<ActivityInfo>(this, android.R.layout.simple_list_item_1, mData);
        lv_listview.setAdapter(arrayAdapter);
        lv_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ActivityInfo activityInfo = mData.get(position);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, activityInfo.name);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
