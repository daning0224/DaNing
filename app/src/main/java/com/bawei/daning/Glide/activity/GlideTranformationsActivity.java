package com.bawei.daning.Glide.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bawei.daning.Glide.adapter.GlideTranformationsAdapter;
import com.bawei.daning.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GlideTranformationsActivity extends AppCompatActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rv_glide_transformations)
    RecyclerView rvGlideTransformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_tranformations);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        tvTitle.setText("Glide图形变换");

        //RecyclerView的适配器
        GlideTranformationsAdapter glideTranformationsAdapter = new GlideTranformationsAdapter(this);
        rvGlideTransformations.setAdapter(glideTranformationsAdapter);
        //LayoutManager
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
