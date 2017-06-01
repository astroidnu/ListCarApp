package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class AttributesData {
    @SerializedName("description")
    public String description;
    @SerializedName("year_built")
    public String yearBuilt;
    @SerializedName("engine")
    public String engine;
    @SerializedName("price_conditions")
    public String priceConditions;
    @SerializedName("price_conditions_id")
    public String priceConditionsId;
    @SerializedName("color_family")
    public String colorFamily;
    @SerializedName("seats")
    public String seats;
    @SerializedName("doors")
    public String doors;
    @SerializedName("drive_type")
    public String driveType;
    @SerializedName("warranty_type")
    public String warrantyType;
    @SerializedName("warranty_years")
    public String warrantyYears;
    @SerializedName("warranty_kms")
    public String warrantyKms;
    @SerializedName("all")
    public AllData all;
}
