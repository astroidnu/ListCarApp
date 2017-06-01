package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class MetaData {
    @SerializedName("product_count")
    public String productCount;
    @SerializedName("results")
    public List<ResultData> resultDataList;
}
