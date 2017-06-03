package com.scoproject.carmudi;

import com.scoproject.carmudi.data.MetaData;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.data.db.CarsData;
import com.scoproject.carmudi.ui.home.HomeActivity;
import com.scoproject.carmudi.ui.home.HomePresenter;
import com.scoproject.carmudi.ui.home.HomeView;
import com.scoproject.carmudi.ui.home.service.HomeResponse;
import com.scoproject.carmudi.ui.home.service.HomeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ibnumuzzakkir on 02/06/2017.
 * Android Developer
 * Garena Indonesia
 */

public class HomePresenterTest {
    @Mock
    HomeActivity homeActivity;
    @Mock
    HomeService homeService;
    @Mock
    HomeResponse homeResponse;
    @Mock
    HomeView homeView;

    HomePresenter homePresenter;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        homePresenter = new HomePresenter(homeActivity, homeService);
        homePresenter.takeView(homeView);
    }

    @Test
    public void getData(){
        HomeResponse homeResponse = new HomeResponse();
        ResultData resultData = new ResultData();
        List<ResultData> resultDatas = new ArrayList<>();
        resultDatas.add(resultData);
        MetaData metadata = new MetaData();
        metadata.resultDataList = resultDatas;
        homeResponse.metadata = metadata;
        when(homeService.getCarsList()).thenReturn(Flowable.just(homeResponse));
        homePresenter.loadData(1,1,true);
        verify(homeView).setProgressIndicator(true);
    }
}
