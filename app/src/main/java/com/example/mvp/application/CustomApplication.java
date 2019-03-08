package com.example.mvp.application;

import android.app.Application;

import com.example.framework.utils.Utils;


/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化工具类
        Utils.init(this);
    }
}
