package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class DetailData {
    @SerializedName("name")
    public String name;
    @SerializedName("label")
    public String label;
    @SerializedName("label_en")
    public String labelEn;
    @SerializedName("value")
    public String value;
}
