package com.scoproject.carmudi.ui.home.service;

import android.util.Log;

import com.scoproject.carmudi.BuildConfig;
import com.scoproject.carmudi.networking.NetworkService;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeService {
    private final NetworkService networkService;
    private int mPageSize;
    private int mMaxItemSize;
    private String mSortItem;

    public void init(int pagesize, int maxitemsize){
        mPageSize = pagesize;
        mMaxItemSize = maxitemsize;
    }

    public void init(int pagesize, int maxitemsize, String sortItem){
        mPageSize = pagesize;
        mMaxItemSize = maxitemsize;
        mSortItem = sortItem;
    }

    public HomeService(NetworkService networkService) {
        this.networkService = networkService;
    }


    public Flowable<HomeResponse> getCarsList() {
        return networkService.getCars(BuildConfig.BASEURL+ "page:"+mPageSize+"/maxitems:"+mMaxItemSize+"/"+"sort:" + mSortItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::handleAccountError)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    private void handleAccountError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }
}
