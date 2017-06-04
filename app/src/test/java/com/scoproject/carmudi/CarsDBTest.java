package com.scoproject.carmudi;

import android.database.sqlite.SQLiteDatabase;

import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.data.db.CarsDataDao;
import com.scoproject.carmudi.data.db.DaoMaster;
import com.scoproject.carmudi.data.db.DaoSession;
import com.scoproject.carmudi.ui.home.HomePresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by ibnumuzzakkir on 6/4/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class CarsDBTest {
    private DaoSession daoSession;
    private CarsDataDao carsDataDao;

    @Before
    public void setUp() throws Exception{
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(RuntimeEnvironment.application, null, null);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
        carsDataDao = daoSession.getCarsDataDao();
    }

    @Test
    public void testBasicsDB() {
        CarsData entity = new CarsData();
        entity.setName("Brio RS 2017");
        entity.setId("123");
        entity.setAgencyName("Ibnu");
        daoSession.insert(entity);
        assertNotNull(entity.getId());
        assertNotNull(carsDataDao.load(entity.getId()));
        assertEquals(1, carsDataDao.count());
        assertEquals(1, daoSession.loadAll(CarsData.class).size());
        daoSession.update(entity);
        daoSession.delete(entity);
        assertNull(carsDataDao.load(entity.getId()));
    }

}
