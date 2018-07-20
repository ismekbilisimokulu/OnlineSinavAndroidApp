package com.ismek.onlinesinav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SinavSonuc extends BaseActivity {

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sinav_sonuc;
    }

    public void logOut(View view) {

    }
}
