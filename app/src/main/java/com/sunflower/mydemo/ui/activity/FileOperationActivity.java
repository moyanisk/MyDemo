package com.sunflower.mydemo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sunflower.mydemo.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileOperationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String FILE_NAME = "hello.txt";

    private EditText et_text;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_operation);
        et_text = (EditText) findViewById(R.id.et_text);
        tv_show = (TextView) findViewById(R.id.tv_show);

        findViewById(R.id.btn_read).setOnClickListener(this);
        findViewById(R.id.btn_write).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write:

                try {
                    OutputStream os = openFileOutput(FILE_NAME, Context.MODE_APPEND);
                    OutputStreamWriter writer = new OutputStreamWriter(os);
                    writer.write(et_text.getText().toString());
                    writer.flush();
                    writer.close();
                    os.close();
                    Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_read:

                FileInputStream fis = null;
                try {
                    fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    StringBuilder str = new StringBuilder();
                    char[] chars = new char[1024];
                    while (isr.read(chars) != -1) {
                        str.append(chars);

                    }
                    isr.close();
                    fis.close();
                    tv_show.setText(str.toString());


//                    BufferedReader bufferedReader = new BufferedReader(isr);
//                    StringBuilder str = new StringBuilder();
//                    String s = "";
//                    while ((s = bufferedReader.readLine()) != null) {
//                        str.append(s);
//
//                    }
//                    tv_show.setText(str.toString());
//                    bufferedReader.close();
//                    isr.close();
//                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

        }
    }
}



