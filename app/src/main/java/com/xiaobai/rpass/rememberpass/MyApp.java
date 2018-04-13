package com.xiaobai.rpass.rememberpass;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.app.Application;
import com.xiaobai.rpass.rememberpass.model.Remember;

/**
 * Created by Administrator on 2018/4/13.
 */

public class MyApp extends Application {
    //为了兼容5.0以上的手机，需添加下面的代码
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration.Builder builder = new Configuration.Builder(this);
        //手动的添加模型类
        builder.addModelClasses(Remember.class);
        ActiveAndroid.initialize(builder.create());
    }
}
