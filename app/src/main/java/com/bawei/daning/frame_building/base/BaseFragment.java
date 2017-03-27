package com.bawei.daning.frame_building.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作    者：云凯文
 * 时    间：2017/2/16
 * 描    述：基类，公共类：CommonFragment,ThirdpartyFragment,CustomFragment,OtherFragment都要继承该类
 * 修改时间：
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获得上下文
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater,container);
    }

    //强制子类重写，实现子类特有的UI
    protected abstract View initView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    //当孩子需要初始化数据，或者联网请求绑定数据，或者展示数据等等，就可以重写该方法
    protected void initData(){

    }



}
