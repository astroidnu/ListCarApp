package com.scoproject.carmudi;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.scoproject.carmudi.data.MetaData;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.data.db.CarsDataDao;
import com.scoproject.carmudi.data.db.DaoMaster;
import com.scoproject.carmudi.data.db.DaoSession;
import com.scoproject.carmudi.helper.NetworkHelper;
import com.scoproject.carmudi.model.CarModel;
import com.scoproject.carmudi.ui.home.HomeActivity;
import com.scoproject.carmudi.ui.home.HomeContract;
import com.scoproject.carmudi.ui.home.HomePresenter;
import com.scoproject.carmudi.ui.home.HomeView;
import com.scoproject.carmudi.ui.home.service.HomeResponse;
import com.scoproject.carmudi.ui.home.service.HomeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ibnumuzzakkir on 02/06/2017.
 * Android Developer
 * Garena Indonesia
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class HomePresenterTest {
    @Mock
    HomeActivity homeActivity;
    @Mock
    HomeService homeService;
    @Mock
    HomeResponse homeResponse;
    @Mock
    HomeView homeView;
//    @Mock
//    DaoSession daoSession;
    @Mock
    NetworkHelper networkHelper;
    HomePresenter homePresenter;
    private DaoSession daoSession;
    private CarsDataDao carsDataDao;
    private CarModel carModel;

    @Before
    public void setUp() throws Exception{
        //Init DB
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(RuntimeEnvironment.application, null, null);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
//        carsDataDao = daoSession.getCarsDataDao();

        //Init Mockito
        MockitoAnnotations.initMocks(this);
//        when(daoSession.getCarsDataDao()).thenReturn(carsDataDao);
        carModel = new CarModel(daoSession);
        homePresenter = new HomePresenter(homeService,carModel);
        homePresenter.takeView(homeView);
    }

    @Test
    public void testPreConditions() {
        assertNotNull(carModel);
    }

//    @Test
//    public void testBasicsDB() {
//        CarsData entity = new CarsData();
//        entity.setName("Brio RS 2017");
//        entity.setId("123");
//        entity.setAgencyName("Ibnu");
//        daoSession.insert(entity);
//        assertNotNull(entity.getId());
//        assertNotNull(carsDataDao.load(entity.getId()));
//        assertEquals(1, carsDataDao.count());
//        assertEquals(1, daoSession.loadAll(CarsData.class).size());
//        daoSession.update(entity);
//        daoSession.delete(entity);
//        assertNull(carsDataDao.load(entity.getId()));
//    }

    @Test
    public void getDataWhenOnline(){
        //Mock Response API
        HomeResponse homeResponse = new HomeResponse();
        CarsData carsData = new CarsData();
        carsData.setName("MobilKu");
        carsData.setAgencyName("Ibnu");
        carsData.setId("1");
        carModel.save(carsData);
        ResultData resultData = new ResultData();
        resultData.setCarsDataList(carsData);
        List<ResultData> resultDatas = new ArrayList<>();
        resultDatas.add(resultData);
        MetaData metadata = new MetaData();
        metadata.resultDataList = resultDatas;
        homeResponse.metadata = metadata;
        //Test Save Response into Database
        when(homeService.getCarsList()).thenReturn(Flowable.just(homeResponse));
        homePresenter.loadData(1,1,true);




        assertEquals(metadata.resultDataList.size(), 1);
//          assertEquals(carModel.loadAll().size(), 1);
        verify(homeView).setProgressIndicator(true);
    }

    @Test
    public void getDataWhenOffline(){
        homePresenter.loadData(1,1,false);
        verify(homeView).setAlertNoInternet(true);
        verify(homeView).setProgressIndicator(false);
    }

    @Test
    public void getLoadMoreWhenDataOnline(){
        HomeResponse homeResponse = new HomeResponse();
        CarsData carsData = new CarsData();
        carsData.setName("MobilKu");
        carsData.setAgencyName("Ibnu");
        carsData.setId("1");
        carModel.save(carsData);
        ResultData resultData = new ResultData();
        resultData.setCarsDataList(carsData);
        List<ResultData> resultDatas = new ArrayList<>();
        resultDatas.add(resultData);
        MetaData metadata = new MetaData();
        metadata.resultDataList = resultDatas;
        homeResponse.metadata = metadata;
        when(homeService.getCarsList()).thenReturn(Flowable.just(homeResponse));
        int mResultDataList = 5;
        homePresenter.loadData(1, mResultDataList + 5, true);
        verify(homeView).setProgressIndicator(true);
    }

    @Test
    public void getLoadMoreDataWhenOffline(){
        int mResultDataList = 5;
        homePresenter.loadData(1, mResultDataList + 5, false);
        verify(homeView).setAlertNoInternet(true);
        verify(homeView).setProgressIndicator(false);
    }

    @Test
    public void getFilterDataWhenOnline(){
        HomeResponse homeResponse = new HomeResponse();
        ResultData resultData = new ResultData();
        List<ResultData> resultDatas = new ArrayList<>();
        resultDatas.add(resultData);
        MetaData metadata = new MetaData();
        metadata.resultDataList = resultDatas;
        homeResponse.metadata = metadata;
        when(homeService.getCarsList()).thenReturn(Flowable.just(homeResponse));
        homePresenter.loadSortData("oldest", true);
        verify(homeView).setProgressIndicator(true);
    }

    @Test
    public void getFilterDataWhenOffline(){
        homePresenter.loadSortData("oldest", false);
        verify(homeView).setProgressIndicator(false);
        verify(homeView).setAlertNoInternet(true);
    }

    @Test
    public void handleResponseErrorAPI(){
        when(homeService.getCarsList()).thenReturn(Flowable.error(new Throwable("test")));
        homePresenter.loadData(1,1,true);
        verify(homeView).setErrorAlter(true, "test");
    }
}
