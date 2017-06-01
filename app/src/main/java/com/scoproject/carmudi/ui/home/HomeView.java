package com.scoproject.carmudi.ui.home;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;

import com.scoproject.carmudi.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@EViewGroup(R.layout.activity_home)
public class HomeView extends CoordinatorLayout {
    @ViewById(R.id.home_recyclerview)
    RecyclerView mHomeRV;

    @AfterViews
    void init(){

    }

    public HomeView(Context context) {
        super(context);
    }
}
