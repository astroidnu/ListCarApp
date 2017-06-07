package com.scoproject.carmudi.ui.home.service;

import android.util.Log;

import com.scoproject.carmudi.BuildConfig;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.networking.NetworkService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
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


    public Flowable<List<CarsData>> getCarsList() {
        return networkService.getCars(BuildConfig.BASEURL+ "page:"+mPageSize+"/maxitems:"+mMaxItemSize+"/"+"sort:" + mSortItem)
                .subscribeOn(Schedulers.io())
                .map(new Function<HomeResponse, List<CarsData>>() {

                    @Override
                    public List<CarsData> apply(@NonNull HomeResponse homeResponse) throws Exception {
                        List<CarsData> mCarsDataList = new ArrayList<>();
                        for(ResultData resultData: homeResponse.metadata.resultDataList){
                            mCarsDataList.add(resultData.carsDataList);
                        }
                        return mCarsDataList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::handleAccountError)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    private void handleAccountError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }
}
