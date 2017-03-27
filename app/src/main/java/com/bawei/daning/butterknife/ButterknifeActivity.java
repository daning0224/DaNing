package com.bawei.daning.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.daning.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterknifeActivity extends Activity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_butterknife)
    TextView tvButterknife;
    @Bind(R.id.cb_butterknife)
    CheckBox cbButterknife;
    @Bind(R.id.bt_butterknife)
    Button btButterknife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        //初始化标题
        tvTitle.setText("Butterknife");
        tvButterknife.setText("我好喜欢Butterknife");
    }

    //checbox的点击事件
    @OnClick(R.id.cb_butterknife)
    void cbButterknife(View view) {
        Toast.makeText(this, "点击了ChecBox", Toast.LENGTH_SHORT).show();
    }

    //button的点击事件
    @OnClick(R.id.bt_butterknife)
    void btButterknife(View view) {
        Toast.makeText(this, "点击了Button", Toast.LENGTH_SHORT).show();
    }
}
