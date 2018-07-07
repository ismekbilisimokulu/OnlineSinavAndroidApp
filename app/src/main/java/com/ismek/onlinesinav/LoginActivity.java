package com.ismek.onlinesinav;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ismek.onlinesinav.entity.Kullanici;
import com.ismek.onlinesinav.util.ApplicationConstant;
import com.ismek.onlinesinav.util.Utils;
import com.ismek.onlinesinav.ws.ApiClient;
import com.ismek.onlinesinav.ws.IRestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        //progressDialog.show();
//        alertDialog.show();
//        alertDialog.yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertDialog.dismiss();
//                showToast("Yes");
//            }
//        });
//
//        alertDialog.no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertDialog.dismiss();
//                showToast("No");
//            }
//        });

        IRestService iService = ApiClient.getClient(LoginActivity.this).create(IRestService.class);
        Call<Kullanici> call = iService.login(Utils.getAuthToken(),"11111111163","5420001564");
        call.enqueue(new Callback<Kullanici>() {
            @Override
            public void onResponse(Call<Kullanici> call, Response<Kullanici> response) {
                Kullanici resp = response.body();
                Log.d("ISMEKKK",""+response.code());

                if (resp != null)
                    Log.d("ISMEKKK",resp.toString());
                else{

                }
            }

            @Override
            public void onFailure(Call<Kullanici> call, Throwable t) {

            }
        });
    }

    public void login(View view){
        if (ApplicationConstant.ISMEK_IP.equals(preferences.getStringValue("ismek_ip",""))){

        }else{
            showAlertDialog(getString(R.string.mes_access_denied),View.VISIBLE,View.GONE,getString(R.string.ok),"");
        }
    }
}
