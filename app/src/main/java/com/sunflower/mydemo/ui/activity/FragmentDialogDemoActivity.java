package com.sunflower.mydemo.ui.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.ui.fragment.MyDialogFragment;

public class FragmentDialogDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dialog_demo);
        findViewById(R.id.btn_show_dialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        showDialog();

    }

    void showDialog() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance();
        newFragment.show(ft, "dialog");
    }
}
