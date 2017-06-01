package com.scoproject.carmudi.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.google.gson.Gson;
import com.scoproject.carmudi.base.ViewPresenter;
import com.scoproject.carmudi.ui.home.service.HomeService;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomePresenter extends ViewPresenter<HomeView> {
    @Inject
    HomeService mHomeService;

    @Inject
    Gson gson;

    private HomeActivity mActivity;
    private CompositeDisposable mCompositeDisposable;

    public HomePresenter(HomeActivity activity){
        mActivity = activity;
    }

    @Override
    public void onLoad(){
        mCompositeDisposable = new CompositeDisposable();
        mHomeService.init(1,10);
        loadData();
        getView().mSwipeRefreshLayout.setOnRefreshListener(() -> loadData());

    }

    public void loadData(){
        getView().mSwipeRefreshLayout.setRefreshing(true);
        mCompositeDisposable.add(
                mHomeService.getCarsList().subscribe(data -> getView().setData(data.metadata.resultDataList),
                        throwable -> onError(throwable)));
    }

    private void onError(Throwable throwable) {
        getView().mSwipeRefreshLayout.setRefreshing(false);
        Log.d(getClass().getName(), throwable.getMessage());
    }
}
