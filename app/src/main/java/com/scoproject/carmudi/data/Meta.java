package com.scoproject.carmudi.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class Meta {
    @SerializedName("price_not_available")
    public String priceNotAvailable;
    @SerializedName("original_price_currency")
    public String originalPriceCurrency;
    @SerializedName("price")
    public String price;
    @SerializedName("original_price")
    public String originalPrice;
    @SerializedName("price_conditions_position")
    public String priceConditionsPosition;
    @SerializedName("price_conditions_id")
    public String priceConditionsId;
    @SerializedName("sku")
    public String sku;
}
