package com.ismek.onlinesinav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ismek.onlinesinav.Adapter.SinavListAdapter;
import com.ismek.onlinesinav.Listener.SinavListener;
import com.ismek.onlinesinav.entity.Sinav;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    public RecyclerView rv;

    private List<Sinav> sinavList;
    private SinavListAdapter adapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        getSinavList();

        adapter = new SinavListAdapter(MainActivity.this, sinavList, new SinavListener() {
            @Override
            public void onClicked(View view, int position) {

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

    }

    private void getSinavList() {
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
