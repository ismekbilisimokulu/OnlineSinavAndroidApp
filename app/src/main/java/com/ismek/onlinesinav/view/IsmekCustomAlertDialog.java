package com.ismek.onlinesinav.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.ismek.onlinesinav.R;

public class IsmekCustomAlertDialog extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public Button yes, no;

    public IsmekCustomAlertDialog(Activity a) {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ismek_custom_alert_dialog);
        yes = findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_yes:
                activity.finish();
                break;

            case R.id.btn_no:
                dismiss();
                break;

            default:
                break;
        }
        dismiss();
    }
}