package com.scoproject.carmudi.model;

import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.data.db.DaoSession;
import com.scoproject.carmudi.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 6/2/17.
 */

public class BaseModel {
    protected final DaoSession mDaoSession;

    public BaseModel(DaoSession daoSession) {
        mDaoSession = daoSession;
    }
}
