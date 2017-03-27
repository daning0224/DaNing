package com.bawei.daning.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.daning.R;
import com.bawei.daning.eventbus.event.MessageEvent;
import com.bawei.daning.eventbus.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends Activity {

    private TextView tv_title;
    private Button btn_eventbus_send;
    private Button btn_eventbus_sticky;
    private TextView tv_eventbus_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        initView();//初始化控件
        initData();//初始化数据
        setListener();//监听事件
    }

    private void setListener() {
        //跳转到发送页面
        btn_eventbus_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventBusActivity.this, EventBusSendActivity.class);
                startActivity(intent);
            }
        });

        //发送粘性事件到发送页面
        btn_eventbus_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.2发送粘性事件
                EventBus.getDefault().postSticky(new StickyEvent("我是粘性事件"));
            }
        });

    }

    private void initData() {
        tv_title.setText("EventBus");
        //1.注册
        EventBus.getDefault().register(EventBusActivity.this);

    }

    //5.接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent messageEvent){
        //显示接收的消息
        tv_eventbus_result.setText(messageEvent.name);
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_eventbus_send = (Button) findViewById(R.id.btn_eventbus_send);
        btn_eventbus_sticky = (Button) findViewById(R.id.btn_eventbus_sticky);
        tv_eventbus_result = (TextView) findViewById(R.id.tv_eventbus_result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.解注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
