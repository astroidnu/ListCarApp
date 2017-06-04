package com.scoproject.carmudi.ui.home;

import android.os.Bundle;
import android.view.View;

import com.scoproject.carmudi.base.BaseActivity;
import com.scoproject.carmudi.di.component.AppComponent;
import com.scoproject.carmudi.helper.NetworkHelper;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.ui.home.adapter.HomeSortingAdapter;
import com.scoproject.carmudi.ui.home.service.HomeService;

import javax.inject.Inject;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeActivity extends BaseActivity implements HomeSortingAdapter.callback, HomeContract.UserActionsListener{
    @Inject
    HomeService mHomeService;

    @Inject
    CarModel mCarModel;

    private HomeComponent mComponent;
    private HomeView mView;
    private HomePresenter mPresenter;
    private HomeSortingAdapter mHomeSortingAdapter;
    private NetworkHelper networkHelper;

    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = HomeView_.build(this);
        mHomeSortingAdapter = new HomeSortingAdapter(this, this);
        setContentView(mView);
        networkHelper = new NetworkHelper(this);
        mPresenter = new HomePresenter(this,mHomeService, networkHelper, mCarModel);
        mPresenter.takeView(mView);
        mView.mToolbarSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.showFilterDialog(mHomeSortingAdapter);
            }
        });
        mPresenter.loadMore();
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerHomeComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.loadData(1,5,networkHelper.isNetworkConnected());
    }

    @Override
    protected boolean isValid() {
        return false;
    }

    @Override
    public void onClickVHItem(String key) {
        mPresenter.loadSortData(key, networkHelper.isNetworkConnected());
    }
}
