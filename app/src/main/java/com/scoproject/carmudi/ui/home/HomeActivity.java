package com.scoproject.carmudi.ui.home;

import android.os.Bundle;

import com.scoproject.carmudi.base.BaseActivity;
import com.scoproject.carmudi.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeActivity extends BaseActivity {
    private HomeComponent mComponent;
    private HomeView mView;
    private HomePresenter mPresenter;

    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = HomeView_.build(this);
        setContentView(mView);
        mPresenter = new HomePresenter(this);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerHomeComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    @Override
    protected boolean isValid() {
        return false;
    }
}
