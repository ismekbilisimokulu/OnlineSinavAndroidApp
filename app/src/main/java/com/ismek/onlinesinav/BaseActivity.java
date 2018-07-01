package com.ismek.onlinesinav;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ismek.onlinesinav.util.SharedPreferenceUtils;
import com.ismek.onlinesinav.view.IsmekCustomAlertDialog;
import com.ismek.onlinesinav.view.IsmekCustomProgressDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    public IsmekCustomProgressDialog progressDialog;
    public IsmekCustomAlertDialog alertDialog;
    public SharedPreferenceUtils preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        progressDialog = new IsmekCustomProgressDialog(this, R.style.CustomDialogTheme);
        alertDialog = new IsmekCustomAlertDialog(this);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        preferences = SharedPreferenceUtils.getInstance(this);
        onViewReady(savedInstanceState, getIntent());
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //Child activity'lerde bunu cagir.
    }

    @Override
    protected void onDestroy() {
        ButterKnife.bind(this);
        super.onDestroy();
    }

    public void noInternetConnectionAvailable() {
        showToast(getString(R.string.noConnection));
    }

    protected void showAlertDialog(String msg) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(null);
        dialogBuilder.setIcon(R.mipmap.ic_launcher);
        dialogBuilder.setMessage(msg);
        dialogBuilder.setPositiveButton(getString(R.string.dialogOkButton), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }

    protected void showToast(String mToastMsg) {
        Toast.makeText(this, mToastMsg, Toast.LENGTH_LONG).show();
    }

    protected abstract int getContentView();
}
