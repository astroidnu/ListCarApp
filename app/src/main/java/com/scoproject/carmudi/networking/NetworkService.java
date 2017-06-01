package com.scoproject.carmudi.networking;

import com.scoproject.carmudi.ui.home.service.HomeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public interface NetworkService {
    @GET
    Observable<HomeResponse> getCars(@Url String url);

}
