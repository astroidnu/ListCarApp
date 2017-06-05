package com.scoproject.carmudi.ui.home;

import com.scoproject.carmudi.di.component.AppComponent;
import com.scoproject.carmudi.di.module.AppModule;
import com.scoproject.carmudi.model.CarModel;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@HomeScope
@Subcomponent(
        modules = HomeModule.class
)
public interface HomeComponent {
    HomeActivity inject(HomeActivity homeActivity);
//    void inject(HomeActivity activity);
//    void inject(HomePresenter mPresenter);
}
