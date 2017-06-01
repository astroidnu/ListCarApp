package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;
import com.scoproject.carmudi.data.db.CarsData;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class ResultData {
    @SerializedName("data")
    public CarsData carsDataList;
    @SerializedName("simples")
    public SimplesData simplesData;
    @SerializedName("attributes")
    public AttributesData attributesData;
    @SerializedName("id")
    public String id;
    @SerializedName("images")
    public List<ImageData> imageDataList;
}
