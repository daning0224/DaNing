package com.bawei.daning.frame_building.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.daning.Afinal.AfinalActivity;
import com.bawei.daning.Glide.activity.GlideActivity;
import com.bawei.daning.R;
import com.bawei.daning.butterknife.ButterknifeActivity;
import com.bawei.daning.eventbus.EventBusActivity;
import com.bawei.daning.frame_building.adapter.CommonFragmentAdapter;
import com.bawei.daning.frame_building.base.BaseFragment;
import com.bawei.daning.okhttp.OkHttpActivity;
import com.bawei.daning.recyclerview.RecyclerViewActivity;

/**
 * 作    者：云凯文
 * 时    间：2017/2/16
 * 描    述：
 * 修改时间：
 */

public class CommonFragment extends BaseFragment {
    private static final String TAG = CommonFragment.class.getCanonicalName();
    private ListView mListView;
    private String datas[];
    private CommonFragmentAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        Log.d(TAG, "常用框架的页面被初始化了");
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        mListView = (ListView) view.findViewById(R.id.mListView);

        //ListView的点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String data = datas[position];

                if (data.toLowerCase().equals("okhttp")) {
                    //点击条目跳转到OkHttp页面
                    Intent intent = new Intent(mContext, OkHttpActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("recyclerview")) {
                    //点击条目跳转到RecyclerView页面
                    Intent intent = new Intent(mContext, RecyclerViewActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("afinal")) {
                    //点击条目跳转到Afinal页面
                    Intent intent = new Intent(mContext, AfinalActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("butterknife")) {
                    //点击条目跳转到Butterknife页面
                    Intent intent = new Intent(mContext, ButterknifeActivity.class);
                    mContext.startActivity(intent);

                } else if (data.toLowerCase().equals("glide")) {
                    //点击条目跳转到Glide页面
                    Intent intent = new Intent(mContext, GlideActivity.class);
                    mContext.startActivity(intent);

                }else if(data.toLowerCase().equals("eventbus")){
                    //点击条目跳转到EventBus页面
                    Intent intent = new Intent(mContext, EventBusActivity.class);
                    mContext.startActivity(intent);
                }

                Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "常用框架页面的数据被初始化了");
        //准备数据
        datas = new String[]{"OKHttp", "RecyclerView", "Afinal", "Butterknife","Glide","EventBus"};
        //设置适配器
        adapter = new CommonFragmentAdapter(mContext, datas);
        mListView.setAdapter(adapter);

    }
}
