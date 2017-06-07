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
import android.widget.Toast;

import com.google.gson.Gson;
import com.scoproject.carmudi.R;
import com.scoproject.carmudi.base.ViewPresenter;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.helper.NetworkHelper;
import com.scoproject.carmudi.helper.RVHelper;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.networking.NetworkError;
import com.scoproject.carmudi.ui.home.adapter.HomeSortingAdapter;
import com.scoproject.carmudi.ui.home.service.HomeResponse;
import com.scoproject.carmudi.ui.home.service.HomeService;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomePresenter extends ViewPresenter<HomeView>{
    private HomeActivity mActivity;
    private CompositeDisposable mCompositeDisposable;
    private List<ResultData> mResultDataList;
    private final static int defaultPage = 1;
    private final static int defaultMaxItem = 5;
    private AlertDialog dialog;
    private HomeService mHomeService;
    private NetworkHelper mNetworkHelper;
    private CarModel mCarModel;
    private Gson mGson;

    public HomePresenter(HomeService service, CarModel carModel, Gson gson){
        mHomeService = service;
        mGson = gson;
        mCarModel = carModel;
    }

    @Override
    public void onLoad(){
        mNetworkHelper = new NetworkHelper(getView().getContext());
        mCompositeDisposable = new CompositeDisposable();
        getView().setOnRefreshListener(() -> loadData(defaultPage,defaultPage));
    }

    /*Load Data From API*/
    public void loadData(int page, int maxSize){
        List<ResultData> resultDataList = new ArrayList<>();
        for(CarsData carsData : mCarModel.loadAll()){
            ResultData resultData = new ResultData();
            resultData.setCarsDataList(carsData);
            resultDataList.add(resultData);
        }
        mResultDataList = resultDataList;
//        getView().setData(resultDataList);
        getView().setProgressIndicator(true);
        mHomeService.init(page,maxSize);
        mCompositeDisposable.add(mHomeService.getCarsList()
                .subscribeWith(new ResourceSubscriber<List<CarsData>>() {
            @Override
            public void onNext(List<CarsData> carsDatas) {
                handleOnSuccess(carsDatas);
            }
            @Override
            public void onError(Throwable e) {
                getView().setProgressIndicator(false);
                if(e instanceof IOException){
                   getView().setData(mCarModel.loadAll());
                }
                getView().setErrorAlter(new NetworkError(e).getAppErrorMessage());
//                  if (e instanceof UnknownHostException) {
//
//                   }else if (e instanceof HttpException) {
//                        getView().setErrorAlter("Error Http");
//                        HttpException httpException = (HttpException) e;
////                        Response response = httpException.response();
////                        Class<ErrorResponse> type = ErrorResponse.class;
////                        Converter<ResponseBody, ErrorResponse> converter = retrofit.responseBodyConverter(type, new Annotation[0]);
////                        try {
////                            ErrorResponse errorResponse = converter.convert(response.errorBody());
////                            Log.d(TAG, errorResponse.error);
////                            Log.d(TAG, errorResponse.error_description);
////                        } catch (IOException e1) {
////                            e1.printStackTrace();
////                        }
////                        Log.d(TAG, response.raw().request().url().toString());
//                    } else {
//                        getView().setErrorAlter(e.getMessage());
//                    }
                }

                @Override
                public void onComplete() {

                }
            }));
//        }else{
//            List<ResultData> resultDataList = new ArrayList<>();
//            for(CarsData carsData : mCarModel.loadAll()){
//                ResultData resultData = new ResultData();
//                resultData.setCarsDataList(carsData);
//                resultDataList.add(resultData);
//            }
//            mResultDataList = resultDataList;
//            getView().setData(resultDataList);
//            getView().setProgressIndicator(false);
//            getView().setAlertNoInternet(true);
//        }
    }

    public void handleOnSuccess(List<CarsData> data){
        Log.d(getClass().getName(), mGson.toJson(data));
        mCarModel.clear();
//        List<ResultData> resultDataList = data.metadata.resultDataList;
        for(CarsData carsData : data){
            mCarModel.save(carsData);
        }
//        mResultDataList = data.metadata.resultDataList;
        getView().setProgressIndicator(false);
        getView().setData(data);
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
//                        loadData(pageIndex++, mResultDataList.size() + 5, mNetworkHelper.isNetworkConnected());
                        loadData(pageIndex++, mResultDataList.size() + 5);
                    }else{
//                        loadData(1, mResultDataList.size() + 5, mNetworkHelper.isNetworkConnected());
                        loadData(1, mResultDataList.size() + 5);
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
        getView().setErrorAlter(throwable.getMessage());
        getView().setProgressIndicator(false);
    }
}
