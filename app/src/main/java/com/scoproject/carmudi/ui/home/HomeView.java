package com.scoproject.carmudi.ui.home;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.scoproject.carmudi.R;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.ui.home.adapter.HomeActivityAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@EViewGroup(R.layout.activity_home)
public class HomeView extends CoordinatorLayout {
    @ViewById(R.id.home_recyclerview)
    RecyclerView mHomeRV;
    @ViewById(R.id.home_progressbar)
    ContentLoadingProgressBar mProgressBar;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.toolbar_sort)
    ImageButton mToolbarSort;
    @ViewById(R.id.home_swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private HomeActivityAdapter mHomeActivityAdapter;

    @AfterViews
    void init(){
        mToolbarTitle.setText("Home");
        mHomeActivityAdapter = new HomeActivityAdapter(getContext());
        mHomeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeRV.setAdapter(mHomeActivityAdapter);

    }

    public void setData(List<ResultData> resultDataList){
        mHomeActivityAdapter.setData(resultDataList);
        mSwipeRefreshLayout.setRefreshing(false);
    }


    public HomeView(Context context) {
        super(context);
    }
}
