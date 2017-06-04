package com.scoproject.carmudi.helper;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ibnumuzzakkir on 6/4/17.
 */

public class NetworkHelper {
    private Context mContext;
    public NetworkHelper(Context context){
        mContext =context;
    }
    public  boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
