package com.bawei.daning.frame_building.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.bawei.daning.R;
import com.bawei.daning.frame_building.base.BaseFragment;
import com.bawei.daning.frame_building.fragment.CommonFragment;
import com.bawei.daning.frame_building.fragment.CustomFragment;
import com.bawei.daning.frame_building.fragment.OtherFragment;
import com.bawei.daning.frame_building.fragment.ThirdPartyFragment;

import java.util.ArrayList;

/**
 * 作    者：云凯文
 * 时    间：2017/2/15
 * 描    述：
 * 修改时间：
 */
public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    private ArrayList<BaseFragment> mBaseFragment;

    //当点击RadioButton时，对应选中的是哪个Fragment的位置
    private int position;
    //上次切换的Fragment
    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化底部View
        initView();
        //初始化Fragment
        initFragment();
        //监听事件
        setListener();
    }


    private void setListener() {
        //RadioGroup的监听事件
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中第一个按钮
        rg_main.check(R.id.rb_common);

    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_common://常用框架
                    position = 0;
                    break;
                case R.id.rb_thirdparty://第三方
                    position = 1;
                    break;
                case R.id.rb_custom://自定义
                    position = 2;
                    break;
                case R.id.rb_other://其他
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = mBaseFragment.get(position);
            //隐藏，显示Fragment
            switchFragment(mFragment, to);
        }
    }

    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            //才切换
            mFragment = to;
            //得到管理者并开启事务
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if (!to.isAdded()) {//如果没有被添加
                //隐藏from
                if (from != null) {
                    transaction.hide(from);
                }
                //添加to
                if (to != null) {
                    transaction.add(R.id.fl_content,to).commit();
                }
            } else {//to已经被添加
                //隐藏from
                if(from!=null){
                    transaction.hide(from);
                }
                //显示to
                if(to!=null){
                    transaction.show(to).commit();
                }
            }
        }
    }

    //根据位置得到对应的Fragment
//    private BaseFragment getFragment() {
//        BaseFragment fragment = mBaseFragment.get(position);
//        return fragment;
//    }

    //初始化Fragment
    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFragment());//常用框架的Fragment
        mBaseFragment.add(new ThirdPartyFragment());//第三方的Fragment
        mBaseFragment.add(new CustomFragment());//自定义控件的Fragment
        mBaseFragment.add(new OtherFragment());//其他的Fragment
    }

    //初始化底部View
    private void initView() {
        rg_main = (RadioGroup) findViewById(R.id.rg_main);

    }
}
