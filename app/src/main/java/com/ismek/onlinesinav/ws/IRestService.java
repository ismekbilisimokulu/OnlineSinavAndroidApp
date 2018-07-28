package com.ismek.onlinesinav.ws;

import com.ismek.onlinesinav.entity.BaseReturn;
import com.ismek.onlinesinav.entity.Ip;
import com.ismek.onlinesinav.entity.Kullanici;
import com.ismek.onlinesinav.entity.Sorular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRestService {

    @GET("kullanici/login/{tcNo}/{telefon}")
    Call<BaseReturn<Kullanici>> login(@Header("Authorization") String authkey, @Path("tcNo") String tcNo, @Path("telefon") String telefon);

    @GET("sinav/findSorularBySinavId/{sinavid}")
    Call<BaseReturn<List<Sorular>>> getQuestions(@Header("Authorization") String authkey, @Path("sinavid") long sinavId);

    @GET("/")
    Call<Ip> IpAdressFind(@Query("format") String format);
}
