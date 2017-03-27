package com.bawei.daning.Afinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.daning.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * 作    者：云凯文
 * 时    间：2017/3/18
 * 描    述：
 * 修改时间：
 */

public class AfinalActivity extends FinalActivity {

    @ViewInject(id = R.id.btn_afinal_loadimage, click = "btn_afinal_loadimage_click")
    private Button btn_afinal_loadimage;
    @ViewInject(id = R.id.btn_afinal_gettext, click = "btn_afinal_gettext_click")
    private Button btn_afinal_gettext;
    @ViewInject(id = R.id.btn_afinal_loadfile, click = "btn_afinal_loadfile_click")
    private Button btn_afinal_loadfile;
    @ViewInject(id = R.id.btn_afinal_updatetext, click = "btn_afinal_updatetext_click")
    private Button btn_afinal_updatetext;
    @ViewInject(id = R.id.iv_afinal)
    private ImageView iv_afinal;
    @ViewInject(id = R.id.tv_afinal_result)
    private TextView tv_afinal_result;
    @ViewInject(id = R.id.tv_title)
    private TextView tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afinal);

        //初始化标题
        iniData();
    }

    private void iniData() {
        tv_title.setText("Afinal");
    }

    //加载图片点击事件
    public void btn_afinal_loadimage_click(View view) {
        Toast.makeText(this, "Afinal加载图片", Toast.LENGTH_SHORT).show();
    }

    //请求文本点击事件
    public void btn_afinal_gettext_click(View view) {
        Toast.makeText(this, "Afinal文本请求", Toast.LENGTH_SHORT).show();
    }

    //加载文件点击事件
    public void btn_afinal_loadfile_click(View view) {
        Toast.makeText(this, "Afinal文件加载", Toast.LENGTH_SHORT).show();
    }

    //上传文本点击事件
    public void btn_afinal_updatetext_click(View view) {
        Toast.makeText(this, "Afinal文件上传", Toast.LENGTH_SHORT).show();
    }

}
