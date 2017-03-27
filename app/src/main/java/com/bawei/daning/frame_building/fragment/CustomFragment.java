package com.bawei.daning.frame_building.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.daning.frame_building.base.BaseFragment;

/**
 * 作    者：云凯文
 * 时    间：2017/2/16
 * 描    述：
 * 修改时间：
 */

public class CustomFragment extends BaseFragment {

    private static final String TAG = CustomFragment.class.getCanonicalName();
    private TextView textView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        Log.d(TAG, "自定义的页面被初始化了");
        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "自定义页面的数据被初始化了");
        textView.setText("自定义控件的页面");
    }
}
