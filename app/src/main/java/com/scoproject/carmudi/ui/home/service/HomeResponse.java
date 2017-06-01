package com.scoproject.carmudi.ui.home.service;

import com.google.gson.annotations.SerializedName;
import com.scoproject.carmudi.data.MetaData;
import com.scoproject.carmudi.networking.CommonResponse;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeResponse extends CommonResponse {
    @SerializedName("metadata")
    public MetaData metadata;

}
