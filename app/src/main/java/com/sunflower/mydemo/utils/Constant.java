package com.sunflower.mydemo.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created xuefei on 2016/1/10.
 */
public class Constant {

    public static final String fileDir = "MyDemo";

    public static int REQUEST_CODE_PICK_IMAGE = 100;
    public static int REQUEST_CODE_CAPTURE_CAMEIA = 101;

    //压缩图片存储路径
    public static final String IMAGECACHE= Environment.getExternalStorageDirectory()+ File.separator+Constant.fileDir+File.separator+"imagecaChe";


//    Constant.SAVED_IMAGE_DIR_PATH

}
