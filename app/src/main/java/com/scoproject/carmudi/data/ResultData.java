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

    public CarsData getCarsDataList() {
        return carsDataList;
    }

    public void setCarsDataList(CarsData carsDataList) {
        this.carsDataList = carsDataList;
    }

    public SimplesData getSimplesData() {
        return simplesData;
    }

    public void setSimplesData(SimplesData simplesData) {
        this.simplesData = simplesData;
    }

    public AttributesData getAttributesData() {
        return attributesData;
    }

    public void setAttributesData(AttributesData attributesData) {
        this.attributesData = attributesData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImageData> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(List<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }
}
