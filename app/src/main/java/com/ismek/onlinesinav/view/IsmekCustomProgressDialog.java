package com.ismek.onlinesinav.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.ismek.onlinesinav.R;

public class IsmekCustomProgressDialog extends ProgressDialog {

    private AnimationDrawable animation;

    public static ProgressDialog ctor(Context context){
        IsmekCustomProgressDialog dialog = new IsmekCustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        return dialog;
    }

    public IsmekCustomProgressDialog(Context context) {
        super(context);
    }

    public IsmekCustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ismek_custom_progress_dialog);

        ImageView image = findViewById(R.id.animation);
        image.setBackgroundResource(R.drawable.custom_progress_dialog_animation);
        animation = (AnimationDrawable) image.getBackground();
    }

    @Override
    public void show() {
        super.show();
        animation.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animation.stop();
    }
}
