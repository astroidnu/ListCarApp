package com.scoproject.carmudi.networking;

import java.net.UnknownHostException;

/**
 * Created by ibnumuzzakkir on 05/06/2017.
 * Android Developer
 * Garena Indonesia
 */

public class NetworkError extends Throwable {
    public static final String NETWORK_ERROR_MESSAGE = "No Internet Connection";
    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
    private final Throwable error;
    public NetworkError(Throwable e){
        super(e);
        this.error = e;
    }

    public String getMessage() { return error.getMessage();}

    public Throwable getError() {
        return error;
    }

    public String getAppErrorMessage(){
        if(this.error instanceof UnknownHostException) return NETWORK_ERROR_MESSAGE;
        return DEFAULT_ERROR_MESSAGE;
    }
}
