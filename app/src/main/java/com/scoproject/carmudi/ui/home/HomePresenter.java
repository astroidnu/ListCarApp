package com.scoproject.carmudi.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.gson.Gson;
import com.scoproject.carmudi.R;
import com.scoproject.carmudi.base.ViewPresenter;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.helper.NetworkHelper;
import com.scoproject.carmudi.helper.RVHelper;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.ui.home.adapter.HomeSortingAdapter;
import com.scoproject.carmudi.ui.home.service.HomeResponse;
import com.scoproject.carmudi.ui.home.service.HomeService;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomePresenter extends ViewPresenter<HomeView>{

    @Inject
    Gson gson;

    private HomeActivity mActivity;
    private CompositeDisposable mCompositeDisposable;
    private List<ResultData> mResultDataList;
    private final static int defaultPage = 1;
    private final static int defaultMaxItem = 5;
    private AlertDialog dialog;
    private HomeService mHomeService;
    private NetworkHelper mNetworkHelper;
    private CarModel mCarModel;

    public HomePresenter(HomeActivity activity, HomeService service,
                         NetworkHelper networkHelper, CarModel carModel){
        mActivity = activity;
        mHomeService = service;
        mNetworkHelper = networkHelper;
        mCarModel = carModel;
    }

    @Override
    public void onLoad(){
        mCompositeDisposable = new CompositeDisposable();
        getView().setOnRefreshListener(() -> loadData(defaultPage,defaultPage,true));
    }

    /*Load Data From API*/
    public void loadData(int page, int maxSize,
                         boolean isNetworkConnected){
        if(isNetworkConnected){
            getView().setProgressIndicator(true);
            mHomeService.init(page,maxSize);
            mCompositeDisposable.add(mHomeService.getCarsList().subscribeWith(new ResourceSubscriber<HomeResponse>() {
                @Override
                public void onNext(HomeResponse homeResponse) {
                        handleOnSuccess(homeResponse);
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onComplete() {

                }
            }));
        }else{
            List<ResultData> resultDataList = new ArrayList<>();
            ResultData resultData = new ResultData();
            for(CarsData carsData : mCarModel.loadAll()){
                resultData.setCarsDataList(carsData);
            }
            resultDataList.add(resultData);
            getView().setData(resultDataList);
            getView().setProgressIndicator(false);
            getView().setAlertNoInternet(true);
        }
    }

    public void handleOnSuccess(HomeResponse data){
        mCarModel.clear();
        List<ResultData> resultDataList = data.metadata.resultDataList;
        for(ResultData resultData : resultDataList){
            CarsData carsData = resultData.carsDataList;
            mCarModel.save(carsData);
        }
        mResultDataList = data.metadata.resultDataList;
        getView().setProgressIndicator(false);
        getView().setData(mResultDataList);
    }

    public void loadMore(){
        getView().mHomeRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RVHelper.lastVisibleItemPosition(recyclerView) >= mResultDataList.size() - 1) {
                    int pageIndex = 1;
                    if(mResultDataList.size() % 100 == 0){
                        loadData(pageIndex++, mResultDataList.size() + 5, mNetworkHelper.isNetworkConnected());
                    }else{
                        loadData(1, mResultDataList.size() + 5, mNetworkHelper.isNetworkConnected());
                    }
                }
            }
        });
    }

    public void loadSortData(String filterKey,   boolean isNetworkConnected){
        getView().hideAlertDialog();
        if(isNetworkConnected){
            getView().setProgressIndicator(true);
            mHomeService.init(defaultPage,defaultMaxItem,filterKey);
            mCompositeDisposable.add(
                    mHomeService.getCarsList().subscribe(data -> handleOnSuccess(data) ,
                            throwable -> onError(throwable)));
        }else{
            getView().setProgressIndicator(false);
            getView().setAlertNoInternet(true);
        }
    }


    public void onError(Throwable throwable) {
        getView().mSwipeRefreshLayout.setRefreshing(false);
        Log.d(getClass().getName(), throwable.getMessage());
    }
}
