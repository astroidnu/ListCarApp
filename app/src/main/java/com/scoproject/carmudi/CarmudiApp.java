package com.scoproject.carmudi;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.scoproject.carmudi.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class CarmudiApp extends MultiDexApplication {
    private static CarmudiApp mInstance;

    private AppComponent mAppComponent;

    public static CarmudiApp getApp(){ return mInstance; }

    @Override
    public void onCreate(){
        super.onCreate();

        MultiDex.install(this);

        mInstance = this;
        mAppComponent = AppComponent.Initializer.init(this);

//        CalligraphyConfig.initDefault(
//                new CalligraphyConfig.Builder()
//                        .setDefaultFontPath("fonts/calibri.ttf")
//                        .setFontAttrId(R.attr.fontPath)
//                        .build()
//        );
    }


    public AppComponent component(){ return mAppComponent;}
}
