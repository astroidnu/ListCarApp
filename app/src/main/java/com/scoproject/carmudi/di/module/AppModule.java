package com.scoproject.carmudi.di.module;

import android.app.Application;

import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.di.scope.AppScope;

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
}
