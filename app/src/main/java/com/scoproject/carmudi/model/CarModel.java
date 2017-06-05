package com.scoproject.carmudi.model;

import android.support.annotation.Nullable;

import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.data.db.CarsDataDao;
import com.scoproject.carmudi.data.db.DaoSession;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ibnumuzzakkir on 6/2/17.
 */

public class CarModel extends BaseModel{
    private CarsDataDao mEntityDao;

    @Inject
    public CarModel(DaoSession daoSession) {
        super(daoSession);
//        app.component().inject(this);
        mEntityDao = daoSession.getCarsDataDao();

    }

    @Nullable
    public List<CarsData> loadAll() {
        return mEntityDao.loadAll();
    }


    @Nullable
    public CarsData load(String id) {
        return mEntityDao.load(id);
    }

    public synchronized void save(CarsData carsData) {
        mEntityDao.insertOrReplace(carsData);
    }

    public void clear() {
        mEntityDao.deleteAll();
    }
}
