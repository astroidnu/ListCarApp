package com.scoproject.carmudi.ui.home;

import com.google.gson.Gson;
import com.scoproject.carmudi.di.scope.AppScope;
import com.scoproject.carmudi.helper.NetworkHelper;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.ui.home.service.HomeService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 05/06/2017.
 * Android Developer
 * Garena Indonesia
 */
@Module
public class HomeModule {
    private HomeActivity mActivity;

    public HomeModule(HomeActivity homeActivity) {
        mActivity = homeActivity;
    }

    @Provides
    @HomeScope
    HomeActivity provideHomeActivity() {
        return mActivity;
    }

    @Provides
    @HomeScope
    HomePresenter homePresenter(HomeService service,
                                 CarModel carModel, Gson gson) {
        return new HomePresenter(service,carModel, gson);
    }
}
