package com.scoproject.carmudi.ui.home;

import com.scoproject.carmudi.di.component.AppComponent;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@HomeScope
@Component(dependencies = {AppComponent.class})
public interface HomeComponent {
    void inject(HomeActivity activity);
    void inject(HomePresenter mPresenter);
}
