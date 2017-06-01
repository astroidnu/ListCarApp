package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class OptionalData {
    @SerializedName("name")
    public String name;
    @SerializedName("label")
    public String label;
    @SerializedName("label_en")
    public String labelEn;
    @SerializedName("options")
    public List<String> options;
}
