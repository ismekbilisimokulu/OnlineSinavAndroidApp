package com.ismek.onlinesinav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;

public class SinavActivity extends BaseActivity {

    @BindView(R.id.webView)
    public WebView webView;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        //webView.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sinav;
    }
}
