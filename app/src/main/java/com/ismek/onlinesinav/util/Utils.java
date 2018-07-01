package com.ismek.onlinesinav.util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Utils {
    public static String getAuthToken(){
        byte[] data = new byte[0];
        try {
            data = (ApplicationConstant.API_USERNAME + ":" + ApplicationConstant.API_PASSWORD).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
