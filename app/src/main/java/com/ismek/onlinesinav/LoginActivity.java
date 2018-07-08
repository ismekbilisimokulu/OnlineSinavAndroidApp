package com.ismek.onlinesinav;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ismek.onlinesinav.entity.Kullanici;
import com.ismek.onlinesinav.util.ApplicationConstant;
import com.ismek.onlinesinav.util.Utils;
import com.ismek.onlinesinav.ws.ApiClient;
import com.ismek.onlinesinav.ws.IRestService;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edTcNo)
    public EditText edTcNo;

    @BindView(R.id.edTelefon)
    public EditText edTelefon;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);


    }

    public void login(View view){
        if (ApplicationConstant.ISMEK_IP.equals(preferences.getStringValue("ismek_ip",""))){

            String tcNo = edTcNo.getText().toString();
            String telefon = edTelefon.getText().toString();

            if (!TextUtils.isEmpty(tcNo) && !TextUtils.isEmpty(telefon)){
                progressDialog.show();
                IRestService iService = ApiClient.getClient(LoginActivity.this).create(IRestService.class);
                Call<Kullanici> call = iService.login(Utils.getAuthToken(),tcNo,telefon);
                call.enqueue(new Callback<Kullanici>() {
                    @Override
                    public void onResponse(Call<Kullanici> call, Response<Kullanici> response) {
                        Kullanici resp = response.body();
                        Log.d("ISMEKKK",""+response.code());

                        progressDialog.dismiss();

                        if (resp != null)
                            Log.d("ISMEKKK",resp.toString());
                        else{
                            showAlertDialog("TC No veya Telefon No Yanlış!",View.VISIBLE,View.GONE,getString(R.string.ok),"");
                        }
                    }

                    @Override
                    public void onFailure(Call<Kullanici> call, Throwable t) {
                        progressDialog.dismiss();
                        showAlertDialog("Hata oluştu! Lütfen sistem yöneticinizle görüşün!",View.VISIBLE,View.GONE,getString(R.string.ok),"");
                    }
                });
            }else{
                showAlertDialog("TC No ve Telefon Boş Bırakılamaz!",View.VISIBLE,View.GONE,getString(R.string.ok),"");
            }


        }else{
            showAlertDialog(getString(R.string.mes_access_denied),View.VISIBLE,View.GONE,getString(R.string.ok),"");
        }
    }
}
