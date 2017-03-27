package com.bawei.daning.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.daning.R;

import java.util.ArrayList;

/**
 * 作    者：云凯文
 * 时    间：2017/2/20
 * 描    述：
 * 修改时间：
 */

public class RecyclerViewActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button btn_add;
    private Button btn_delete;
    private Button btn_list;
    private Button btn_grid;
    private Button btn_slow;
    private RecyclerView recyclerView;
    private ArrayList<String> datas;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        //初始化View
        initView();

        //初始化数据
        initData();

        //设置RecyclerView的适配器
        adapter = new MyRecyclerViewAdapter(RecyclerViewActivity.this, datas);
        recyclerView.setAdapter(adapter);

        //添加RecyclerView的分割线
        recyclerView.addItemDecoration(new DividerListItemDecoration(RecyclerViewActivity.this,
                DividerListItemDecoration.VERTICAL_LIST));

        //设置RecyclerView的点击事件
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(RecyclerViewActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData() {
        //准备数据
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("Content_" + i);
        }
    }

    private void initView() {
        //初始化控件
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_list = (Button) findViewById(R.id.btn_list);
        btn_grid = (Button) findViewById(R.id.btn_grid);
        btn_slow = (Button) findViewById(R.id.btn_slow);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置头部标题
        tv_title.setText("RecyclerView");
        //设置点击事件
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        btn_slow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                adapter.addData(0,"new Content");
                recyclerView.scrollToPosition(0);
                break;
            case R.id.btn_delete:
                adapter.removeData(0);
                break;
            case R.id.btn_list:
                //LayoutManager
                recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this,
                        LinearLayoutManager.VERTICAL, false));
//              recyclerView.scrollToPosition(datas.size()-1);  //设置从哪一个条目开始显示
                break;
            case R.id.btn_grid:
                recyclerView.setLayoutManager(new GridLayoutManager(RecyclerViewActivity.this,
                        3, GridLayoutManager.VERTICAL, false));
//                recyclerView.scrollToPosition(datas.size()-1);
                break;
            case R.id.btn_slow:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( 3,
                        StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }
}
