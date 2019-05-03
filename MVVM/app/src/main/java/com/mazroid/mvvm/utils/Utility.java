package com.mazroid.mvvm.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by MazRoid on 5/3/2019.
 */
public class Utility {


    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }

        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return activeNetworkInfo != null;
    }
}
