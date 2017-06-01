package com.scoproject.carmudi.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.scoproject.carmudi.base.ViewPresenter;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.helper.RVHelper;
import com.scoproject.carmudi.ui.home.service.HomeResponse;
import com.scoproject.carmudi.ui.home.service.HomeService;

import java.util.List;

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
    private List<ResultData> mResultDataList;
    private final static int defaultPage = 1;
    private final static int detaultMaxItem = 5;

    public HomePresenter(HomeActivity activity){
        mActivity = activity;
    }

    @Override
    public void onLoad(){
        mCompositeDisposable = new CompositeDisposable();
        loadData(defaultPage,detaultMaxItem, true);
        loadMore();
        onSort();
        getView().mSwipeRefreshLayout.setOnRefreshListener(() -> loadData(1,mResultDataList.size(), true));

    }
    /*Load Data From API*/
    public void loadData(int page, int maxSize, boolean isSwipeRefresh){
        if(isSwipeRefresh){
            getView().mSwipeRefreshLayout.setRefreshing(true);
        }
        mHomeService.init(page,maxSize);
        mCompositeDisposable.add(
                mHomeService.getCarsList().subscribe(data -> handleOnSuccess(data) ,
                        throwable -> onError(throwable)));
    }

    public void handleOnSuccess(HomeResponse data){
        mResultDataList = data.metadata.resultDataList;
        getView().setData(mResultDataList);
        getView().mProgressBar.hide();
        getView().mSwipeRefreshLayout.setRefreshing(false);

    }

    public void loadMore(){
        getView().mProgressBar.show();
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

    private void onSort(){
        getView().mToolbarSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getClass().getName(), "onClickSort()");
            }
        });
    }

    public void onError(Throwable throwable) {
        getView().mSwipeRefreshLayout.setRefreshing(false);
        getView().mProgressBar.hide();
        Log.d(getClass().getName(), throwable.getMessage());
    }
}
