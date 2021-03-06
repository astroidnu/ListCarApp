package com.scoproject.carmudi.data.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.scoproject.carmudi.data.db.CarsData;

import com.scoproject.carmudi.data.db.CarsDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig carsDataDaoConfig;

    private final CarsDataDao carsDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        carsDataDaoConfig = daoConfigMap.get(CarsDataDao.class).clone();
        carsDataDaoConfig.initIdentityScope(type);

        carsDataDao = new CarsDataDao(carsDataDaoConfig, this);

        registerDao(CarsData.class, carsDataDao);
    }
    
    public void clear() {
        carsDataDaoConfig.clearIdentityScope();
    }

    public CarsDataDao getCarsDataDao() {
        return carsDataDao;
    }

}
