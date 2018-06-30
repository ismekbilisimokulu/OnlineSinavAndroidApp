package com.ismek.onlinesinav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifImg = findViewById(R.id.gifImg);

        Glide.with(getApplicationContext()).asGif().load(R.drawable.loading).into(gifImg);
    }
}
