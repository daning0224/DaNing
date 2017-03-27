package com.bawei.daning.frame_building.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 作    者：云凯文
 * 时    间：2017/2/16
 * 描    述：
 * 修改时间：
 */

public class CommonFragmentAdapter extends BaseAdapter {

    private Context mContext;
    private String[] datas;

    //构造方法
    public CommonFragmentAdapter(Context mContext, String[] datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setPadding(10, 10, 10, 10);
        textView.setTextColor(Color.BLACK);
        textView.setText(datas[position]);
        return textView;
    }
}
