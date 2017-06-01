package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;
import com.scoproject.carmudi.data.db.CarsData;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class ResultData {
    @SerializedName("data")
    public List<CarsData> carsDataList;
    @SerializedName("id")
    public String id;
    @SerializedName("images")
    public List<ImageData> imageDataList;
}
