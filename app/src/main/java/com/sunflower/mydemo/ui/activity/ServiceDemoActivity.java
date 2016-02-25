package com.sunflower.mydemo.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.service.MyService;

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {



    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        findViewById(R.id.btn_bind).setOnClickListener(this);
        findViewById(R.id.btn_unbind).setOnClickListener(this);
        tv_show = (TextView) findViewById(R.id.tv_show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.btn_stop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.btn_bind:
                bindService(new Intent(this, MyService.class),this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(this);
                break;

        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
