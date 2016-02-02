package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sunflower.mydemo.R;

/**
 * author xuefei on 20160202
 */
public class VolleyDemoActivity extends AppCompatActivity {

    private TextView tv_text;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_demo);
        init();
    }

    private void init () {
        requestQueue = Volley.newRequestQueue(this);
        tv_text = (TextView) findViewById(R.id.tv_text);
        String url = "http://www.baidu.com/";
        requestQueue.add(new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                tv_text.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                tv_text.setText(volleyError.toString());
            }
        }));
    }

}
