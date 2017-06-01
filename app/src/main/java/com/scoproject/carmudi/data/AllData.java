package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class AllData {
    @SerializedName("details")
    public List<DetailData> details;
    @SerializedName("optional")
    public List<OptionalData> optional;
}
