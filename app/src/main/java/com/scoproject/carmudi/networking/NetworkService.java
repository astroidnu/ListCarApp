package com.scoproject.carmudi.networking;

import com.scoproject.carmudi.ui.home.service.HomeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public interface NetworkService {
    @GET("page:{page_size}/maxitems:{max_item_size}/")
    Observable<HomeResponse> getCars(@Path("page_size") int pageSize, @Path("max_item_size") int maxItemSize);

}
