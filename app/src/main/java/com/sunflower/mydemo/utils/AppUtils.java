package com.sunflower.mydemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuefei on 2016/1/10.
 */
public class AppUtils {

    /**
     * 创建图片名称
     *
     * @param dateTaken
     * @return
     */
    public static String createName(long timeMillis) {
        Date date = new Date(timeMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date);
    }

}
