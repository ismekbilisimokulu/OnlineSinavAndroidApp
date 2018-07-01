package com.ismek.onlinesinav.ws;

import com.ismek.onlinesinav.entity.Kullanici;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface IRestService {

    @GET("login/{tcNo}/{telefon}")
    Call<Kullanici> login(@Header("Authorization") String authkey, @Path("tcNo") String tcNo, @Path("telefon") String telefon);
}
