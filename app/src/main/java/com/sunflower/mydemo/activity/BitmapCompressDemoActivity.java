package com.sunflower.mydemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sunflower.mydemo.R;
import com.sunflower.mydemo.utils.AppUtils;
import com.sunflower.mydemo.utils.BitmapUtils;
import com.sunflower.mydemo.utils.Constant;

import java.io.File;

/**
 * author xuefei  create 2016/01/10
 * bitmap图片压缩实例
 */
public class BitmapCompressDemoActivity extends AppCompatActivity {

    private ImageView mIvImageView;
    private Bitmap mBitmap;
    private String mCapturePath;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_compress_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    private void init () {
        Button btnLoadImage = (Button) findViewById(R.id.btn_load_image);
        mIvImageView = (ImageView) findViewById(R.id.iv_imageview);
        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromAlbum();
            }
        });

        Button btnPhotograph = (Button)findViewById(R.id.btn_photograph);

        btnPhotograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromCamera();
            }
        });
    }

    /**
     * 从相册中获取图片
     */
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
//        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, Constant.REQUEST_CODE_PICK_IMAGE);
    }

    /**
     * 启动相机拍照获取图片
     */
    protected void getImageFromCamera() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
            String out_file_path = Constant.IMAGECACHE;
            File dir = new File(out_file_path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            mCapturePath = Constant.IMAGECACHE + File.separator + System.currentTimeMillis() + ".jpg";

            getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mCapturePath)));
            startActivityForResult(getImageByCamera, Constant.REQUEST_CODE_CAPTURE_CAMEIA);
        }
        else {
            Toast.makeText(getApplicationContext(), "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constant.REQUEST_CODE_PICK_IMAGE) {
            Uri uri = data.getData();
            Log.d(this.getClass().getSimpleName(), "uri = " + uri);
            if (uri != null) {
                mBitmap = BitmapUtils.getBitmapCompressFromFile(uri.toString().substring(7),800,600);

                mIvImageView.setImageBitmap(mBitmap);

//                String filepath = Constant.IMAGECACHE+ File.separator + AppUtils.createName(System.currentTimeMillis())+"."+"jpg";
//                BitmapUtils.saveImage(bitmap,filepath);
//                if (!bitmap.isRecycled()) {
//                    bitmap.recycle();
//                }

            }
        } else if (requestCode == Constant.REQUEST_CODE_CAPTURE_CAMEIA) {

//            存放到指定的文件
                mBitmap = BitmapUtils.getBitmapCompressFromFile(mCapturePath,800,600);
                mIvImageView.setImageBitmap(mBitmap);



            /*
            Uri uri = data.getData();
            if(uri == null){
                //use bundle to get data
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    Bitmap  photo = (Bitmap) bundle.get("data"); //get bitmap
                    //spath :生成图片取个名字和路径包含类型
                    mIvImageView.setImageBitmap(photo);
                    String filepath = Constant.IMAGECACHE+ File.separator + AppUtils.createName(System.currentTimeMillis())+"."+"jpg";
                    BitmapUtils.saveImage(photo,filepath);
                } else {
                    Toast.makeText(getApplicationContext(), "err****", Toast.LENGTH_LONG).show();
                    return;
                }
            }else{
                //to do find the path of pic by uri
                Log.d(this.getClass().getSimpleName(),"uri = " + uri);
            }*/
        }
    }

    @Override
    protected void onDestroy() {

        if (mBitmap != null && !mBitmap.isRecycled()) {
            mBitmap.recycle();
            mBitmap = null;
            System.gc();
        }

        super.onDestroy();
    }
}
