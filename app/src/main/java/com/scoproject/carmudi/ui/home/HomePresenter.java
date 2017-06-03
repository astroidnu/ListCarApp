package com.scoproject.carmudi.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
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

    @Inject
    CarModel mCarModel;

    private HomeActivity mActivity;
    private CompositeDisposable mCompositeDisposable;
    private List<ResultData> mResultDataList;
    private final static int defaultPage = 1;
    private final static int defaultMaxItem = 5;
    private AlertDialog dialog;
    private HomeService mHomeService;

    public HomePresenter(HomeActivity activity, HomeService service){
        mActivity = activity;
        mHomeService = service;
    }

    @Override
    public void onLoad(){
        mCompositeDisposable = new CompositeDisposable();
//        loadData(defaultPage,defaultMaxItem, true);
//        if(isNetworkConnected()){

//        }else{
//            mResultDataList = new ArrayList<>();
//            Log.d(getClass().getName(), gson.toJson(mCarModel.loadAll()));
//            ResultData resultData = new ResultData();
//            for(CarsData carsData : mCarModel.loadAll()){
//                resultData.setCarsDataList(carsData);
//                mResultDataList.add(resultData);
//            }
//            Log.d(getClass().getName(), gson.toJson(mResultDataList));
//            getView().setData(mResultDataList);
//            getView().mProgressBar.hide();
//        }
//        getView().mSwipeRefreshLayout.setOnRefreshListener(() -> loadData(1,mResultDataList.size(), true));

    }

    @Override
    public void onResume(){
        super.onResume();

    }

    /*Load Data From API*/
    public void loadData(int page, int maxSize, boolean isSwipeRefresh){
//        internet = isNetworkConnected();
//        if(internet){
//            if(isSwipeRefresh){
//                getView().mSwipeRefreshLayout.setRefreshing(true);
//            }else{
//                getView().mProgressBar.show();
//            }
            mHomeService.init(page,maxSize);
        getView().setProgressIndicator(true);
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

//                    mHomeService.getCarsList().subscribe(data -> handleOnSuccess(data) ,
//                            throwable -> onError(throwable));
//        }else{
//            getView().mProgressBar.hide();
//            getView().mSwipeRefreshLayout.setRefreshing(false);
//            Snackbar.make(getView(), "No Internet Connection", Snackbar.LENGTH_SHORT).show();
//        }
    }

    public void handleOnSuccess(HomeResponse data){
        getView().setProgressIndicator(false);
//        mCarModel.clear();
        List<ResultData> resultDataList = data.metadata.resultDataList;
//        for(ResultData resultData : resultDataList){
//            CarsData carsData = resultData.carsDataList;
//            mCarModel.save(carsData);
//        }
        mResultDataList = data.metadata.resultDataList;
        getView().setData(mResultDataList);
        getView().mProgressBar.hide();
        getView().mSwipeRefreshLayout.setRefreshing(false);

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
                        loadData(pageIndex++, mResultDataList.size() + 5, false);
                    }else{
                        loadData(1, mResultDataList.size() + 5, false);
                    }
//                    Log.d(getClass().getName(), String.valueOf(RVHelper.lastVisibleItemPosition(recyclerView)));
                }
            }
        });
    }

    public void loadSortData(String filterKey){
        getView().mAlertDialog.hide();
        if(isNetworkConnected()){
            getView().mProgressBar.show();
            mHomeService.init(defaultPage,defaultMaxItem,filterKey);
            mCompositeDisposable.add(
                    mHomeService.getCarsList().subscribe(data -> handleOnSuccess(data) ,
                            throwable -> onError(throwable)));
        }else{
            Snackbar.make(getView(), "No Internet Connection", Snackbar.LENGTH_SHORT).show();
            getView().mProgressBar.hide();
        }

    }

    public void onError(Throwable throwable) {
        getView().mSwipeRefreshLayout.setRefreshing(false);
        getView().mProgressBar.hide();
        Log.d(getClass().getName(), throwable.getMessage());
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
