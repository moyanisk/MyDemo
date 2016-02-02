package com.sunflower.mydemo.model;

/**
 * Created by yunlala-web on 2016/1/29.
 */
public class ActivityInfo {
    public String title;
    public Class<?> name;

    public ActivityInfo(String title, Class<?> name) {
        this.title = title;
        this.name = name;
    }

    public String toString() {
        return title;
    }
}

