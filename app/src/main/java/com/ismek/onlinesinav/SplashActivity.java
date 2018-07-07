package com.ismek.onlinesinav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ismek.onlinesinav.entity.Ip;
import com.ismek.onlinesinav.entity.Kullanici;
import com.ismek.onlinesinav.util.Utils;
import com.ismek.onlinesinav.ws.ApiClient;
import com.ismek.onlinesinav.ws.ApiClientIP;
import com.ismek.onlinesinav.ws.IRestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity {

    private static final int SPLASHTIME = 3000;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        IRestService iService = ApiClientIP.getClient(SplashActivity.this).create(IRestService.class);
        Call<Ip> call = iService.IpAdressFind("json");

        call.enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                Ip resp = response.body();

                if (resp != null)
                    preferences.setValue("ismek_ip",resp.getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {

            }
        });

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(SPLASHTIME);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected int getContentView() {
        return R.layout.splash;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
