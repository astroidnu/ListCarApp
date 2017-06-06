package com.scoproject.carmudi.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.di.module.AppModule;
import com.scoproject.carmudi.di.module.AppUIModule;
import com.scoproject.carmudi.di.module.NetworkModule;
import com.scoproject.carmudi.di.scope.AppScope;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.ui.home.HomeComponent;
import com.scoproject.carmudi.ui.home.HomeModule;
import com.scoproject.carmudi.ui.home.service.HomeService;

import java.io.File;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@AppScope
@Component(
        modules = {AppModule.class, AppUIModule.class, NetworkModule.class}
)
public interface AppComponent extends IAppComponent {
    final static class Initializer {
         public static AppComponent init(CarmudiApp app){
            File cacheFile = new File(app.getCacheDir(), "responses");
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .networkModule(new NetworkModule(cacheFile))
                    .build();
        }
    }
    Application getApplication();
    HomeComponent plus(HomeModule homeModule);
}
