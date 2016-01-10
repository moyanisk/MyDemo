package com.sunflower.mydemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by xuefei on 2016/1/10.
 */
public class BitmapUtils {


    /**
     * 计算合适的insamplesize的值
     * @param options  BitmapFactory创建图片的配置
     * @param reqWidth  期望的宽度
     * @param reqHeight 期望的高度
     * @return   inSampleSize
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }
        return inSampleSize;
    }


    /**
     * 保存图片
     * @param photo
     * @param spath
     */
    public static void saveImage(Bitmap photo, String spath) {
        try {
            File file = new File(spath);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(spath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取压缩图片
     * @param path
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap getBitmapCompressFromFile (String path, int reqWidth, int reqHeight) {

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, opts);
        int inSampleSize = BitmapUtils.calculateInSampleSize(opts, reqWidth, reqHeight);
        opts.inSampleSize = inSampleSize;
        opts.inJustDecodeBounds = false;
        opts.inPreferredConfig = Bitmap.Config.RGB_565;

        Bitmap bitmap = BitmapFactory.decodeFile(path,opts);
        return bitmap;
    }
}
