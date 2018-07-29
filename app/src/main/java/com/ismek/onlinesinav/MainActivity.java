package com.ismek.onlinesinav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ismek.onlinesinav.Adapter.SinavListAdapter;
import com.ismek.onlinesinav.Listener.SinavListener;
import com.ismek.onlinesinav.entity.BaseReturn;
import com.ismek.onlinesinav.entity.Kullanici;
import com.ismek.onlinesinav.entity.Sinav;
import com.ismek.onlinesinav.util.ApplicationConstant;
import com.ismek.onlinesinav.util.Utils;
import com.ismek.onlinesinav.ws.ApiClient;
import com.ismek.onlinesinav.ws.IRestService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    public RecyclerView rv;

    @BindView(R.id.headerTxt)
    public TextView headerTxt;

    private List<Sinav> sinavList;
    private SinavListAdapter adapter;

    private Kullanici kullanici;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        kullanici = getIntent().getParcelableExtra("kullanici");
        headerTxt.setText("Hoşgeldiniz ,\n"+kullanici.getAd()+" "+kullanici.getSoyAdi());
        getSinavList();




    }

    private void getSinavList() {
        sinavList = new ArrayList<>();
            progressDialog.show();
            IRestService iService = ApiClient.getClient(MainActivity.this).create(IRestService.class);
            Call<List<Sinav>> call = iService.getSinav(Utils.getAuthToken(),kullanici.getKullaniciId());
            call.enqueue(new Callback<List<Sinav>>() {
                @Override
                public void onResponse(Call<List<Sinav>> call, Response<List<Sinav>> response) {
                    sinavList = response.body();
                    Log.d("ISMEKKK",""+response.code());

                    progressDialog.dismiss();

                    if (sinavList != null && sinavList.size()>0){
                        adapter = new SinavListAdapter(MainActivity.this, sinavList, new SinavListener() {
                            @Override
                            public void onClicked(View view, int position) {
                                Intent i = new Intent(MainActivity.this,SinavActivity.class);
                                Bundle b = new Bundle();
                                b.putParcelable("sinav",sinavList.get(position));
                                i.putExtras(b);
                                startActivity(i);
                            }
                        });
                        Log.d("SINAV", "onResponse: "+sinavList.size());
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        rv.setLayoutManager(layoutManager);
                        rv.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Sinav>> call, Throwable t) {
                    progressDialog.dismiss();
                    showAlertDialog("Hata oluştu! Lütfen sistem yöneticinizle görüşün!",View.VISIBLE,View.GONE,getString(R.string.ok),"",new Callable<Void>() {
                        public Void call() {
                            return null;
                        }
                    });
                }
            });

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
