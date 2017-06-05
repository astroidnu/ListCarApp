package com.scoproject.carmudi.di.module;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.data.db.DaoMaster;
import com.scoproject.carmudi.data.db.DaoSession;
import com.scoproject.carmudi.di.scope.AppScope;
import com.scoproject.carmudi.model.CarModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@Module
public class AppModule {
    private final CarmudiApp mApp;

    public AppModule(CarmudiApp app){ this.mApp = app; }

    @Provides
    @AppScope
    Application provideApplicationContext(){ return mApp; }

    @Provides
    @AppScope
    DaoSession provideDaoSession() {
        String DbName = "carmudidb";
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(CarmudiApp.getApp(), DbName);
        Log.d("New DB Name: ", DbName);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        Log.d("Schema DB" , String.valueOf(daoMaster.getSchemaVersion()));
        return daoMaster.newSession();
    }

//    Provide Model
    @Provides
    @AppScope
    CarModel provideCarModel(DaoSession daoSession) {
        return new CarModel(daoSession);
    }
}
