package com.ismek.onlinesinav;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ismek.onlinesinav.util.SharedPreferenceUtils;
import com.ismek.onlinesinav.view.IsmekCustomProgressDialog;

import java.util.concurrent.Callable;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    public IsmekCustomProgressDialog progressDialog;
    public SharedPreferenceUtils preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getContentView());

        ButterKnife.bind(this);
        progressDialog = new IsmekCustomProgressDialog(this, R.style.CustomDialogTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
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

    protected void showToast(String mToastMsg) {
        Toast.makeText(this, mToastMsg, Toast.LENGTH_LONG).show();
    }

    public Dialog showAlertDialog(String message, int btnYesVisibility, int btnNoVisibility, String positiveText, String negativeText, final Callable<Void> positiveFunction) {

        // dialog nesnesi oluştur ve layout dosyasına bağlan
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.ismek_custom_alert_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // custom dialog elemanlarını tanımla - text, image ve button
        Button btnYes = (Button) dialog.findViewById(R.id.btn_yes);
        Button btnNo = (Button) dialog.findViewById(R.id.btn_no);
        btnYes.setVisibility(btnYesVisibility);
        btnNo.setVisibility(btnNoVisibility);
        btnYes.setText(positiveText);
        btnNo.setText(negativeText);

        TextView txtMessage = (TextView) dialog.findViewById(R.id.txtMessage);


        // custom dialog elemanlarına değer ataması yap - text, image
        txtMessage.setText(message);

        // tamam butonunun tıklanma olayları
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (positiveFunction.call() == null){
                        dialog.dismiss();
                    }
                    else{
                        positiveFunction.call();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // iptal butonunun tıklanma olayları
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        return dialog;
    }

    protected abstract int getContentView();
}
