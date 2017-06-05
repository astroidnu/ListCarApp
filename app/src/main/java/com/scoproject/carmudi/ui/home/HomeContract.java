package com.scoproject.carmudi.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;

import com.scoproject.carmudi.data.ResultData;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 02/06/2017.
 * Android Developer
 * Garena Indonesia
 */

public interface HomeContract {
    interface View{
        void setProgressIndicator(boolean active);
        void setData(List<ResultData> resultDataList);
        void setAlertNoInternet(boolean active);
        void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener onRefreshListener);
        void hideAlertDialog();
        void setErrorAlter(String msg);
    }

    interface UserActionsListener{

    }
}
