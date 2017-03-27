package com.bawei.daning.Glide.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.daning.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends Activity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn_glide_base)
    Button btnGlideBase;
    @Bind(R.id.btn_glide_recyclerview)
    Button btnGlideRecyclerview;
    @Bind(R.id.btn_glide_tranfromations)
    Button btnGlideTranfromations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {
        tvTitle.setText("Glide");
    }

    //基本使用
    @OnClick(R.id.btn_glide_base)
    void btn_glide_base_click(View view) {
        Intent intent = new Intent(GlideActivity.this, GlideBaseActivity.class);
        startActivity(intent);
    }

    //在RecyclerView中使用
    @OnClick(R.id.btn_glide_recyclerview)
    void btn_glide_recyclerview_click(View view) {
        Intent intent = new Intent(GlideActivity.this, GlideRecyclerViewActivity.class);
        startActivity(intent);
    }

    //图片变换
    @OnClick(R.id.btn_glide_tranfromations)
    void btn_glide_tranfromations_click(View view) {
        Intent intent = new Intent(GlideActivity.this, GlideTranformationsActivity.class);
        startActivity(intent);
    }
}
