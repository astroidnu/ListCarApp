package com.scoproject.carmudi.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.scoproject.carmudi.R;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.ui.home.adapter.HomeActivityAdapter;
import com.scoproject.carmudi.ui.home.adapter.HomeSortingAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@EViewGroup(R.layout.activity_home)
public class HomeView extends CoordinatorLayout implements HomeContract.View{
    @ViewById(R.id.home_recyclerview)
    RecyclerView mHomeRV;
    @ViewById(R.id.home_progressbar)
    LinearLayout mProgressBar;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.toolbar_sort)
    ImageButton mToolbarSort;
    @ViewById(R.id.home_swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private HomeActivityAdapter mHomeActivityAdapter;

    private LayoutInflater mLayoutInflater;
    public AlertDialog mAlertDialog;

    @AfterViews
    void init(){
        mToolbarTitle.setText("Home");
        mLayoutInflater = LayoutInflater.from(getContext());
        mHomeActivityAdapter = new HomeActivityAdapter(getContext());
        mHomeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeRV.setAdapter(mHomeActivityAdapter);
    }

    @Override
    public void setProgressIndicator(boolean active) {
        mSwipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void setData(List<ResultData> resultDataList){
        mHomeActivityAdapter.setData(resultDataList);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setAlertNoInternet(boolean active) {
        Snackbar.make(this, "No Internet Connection", Snackbar.LENGTH_SHORT).show();
    }

    public void showFilterDialog(HomeSortingAdapter homeSortingAdapter){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater =  mLayoutInflater;
        final View dialogView = inflater.inflate(R.layout.sorting, null);
        RecyclerView mSortingRV = (RecyclerView) dialogView.findViewById(R.id.sorting_recyclerview);
        mSortingRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mSortingRV.setAdapter(homeSortingAdapter);
        dialogBuilder.setView(dialogView);
        mAlertDialog = dialogBuilder.create();
        mAlertDialog.show();
    }

    public HomeView(Context context) {
        super(context);
    }

}
