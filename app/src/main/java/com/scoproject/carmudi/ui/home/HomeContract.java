package com.scoproject.carmudi.ui.home;

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
    }

    interface UserActionsListener{
        void loadSortData(String key);
    }
}
