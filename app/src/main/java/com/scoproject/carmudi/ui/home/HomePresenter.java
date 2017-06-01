package com.scoproject.carmudi.ui.home;

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

    public HomePresenter(HomeActivity activity){
        mActivity = activity;
    }

    @Override
    public void onLoad(){
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mHomeService.init(1,1);
        compositeDisposable.add(
                mHomeService.getCarsList().subscribe(data ->  Log.d(getClass().getName(),gson.toJson(data)),
                        throwable -> onError(throwable)));
    }

    private void onError(Throwable throwable) {
        Log.d(getClass().getName(), throwable.getMessage());
    }
}
