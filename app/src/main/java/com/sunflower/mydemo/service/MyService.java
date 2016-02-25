package com.sunflower.mydemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.sunflower.mydemo.utils.LogUtils;

public class MyService extends Service {

    private static final String TAG = LogUtils.makeLogTag(MyService.class);
    private boolean mIsRunning = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.LOGD(TAG, "onBind");
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }

    private class MyBinder extends Binder {


    }

    @Override
    public void onCreate() {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "1111111");
        }
        LogUtils.LOGD(TAG, "onCreate");
        mIsRunning = true;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.LOGD(TAG, "onStartCommand");

        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (mIsRunning) {
                    i++;
                    LogUtils.LOGD(TAG, "子线程输出 " + i);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.LOGD(TAG, "onDestroy");
        mIsRunning = false;
        super.onDestroy();
    }

    interface MyServiceChange {
        public void change();
    }
}
