package com.sunflower.mydemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sunflower.mydemo.R;

public class ToastShowActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_show);

        findViewById(R.id.btn_toast_short_show).setOnClickListener(this);
        findViewById(R.id.btn_toast_long_show).setOnClickListener(this);
        findViewById(R.id.btn_toast_new_layout).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast_short_show:
                Toast.makeText(this, "Hello 大傻逼！", Toast.LENGTH_SHORT).show();
            break;
            case R.id.btn_toast_long_show:
                Toast.makeText(this, "Hello 大傻逼！", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_toast_new_layout:
                Toast toast = Toast.makeText(this, "Hello 大傻逼！", Toast.LENGTH_SHORT);
//                ImageView imageView = new ImageView(this);
//                imageView.setImageResource(R.mipmap.ic_launcher);
//                toast.setView(imageView);
                View toastView = getLayoutInflater().inflate(R.layout.toast_view, null);
                toast.setView(toastView);
                toast.show();
                break;
        }
    }
}
