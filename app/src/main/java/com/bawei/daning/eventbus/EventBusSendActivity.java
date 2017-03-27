package com.bawei.daning.eventbus;

import android.app.Activity;
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

public class EventBusSendActivity extends Activity {

    private TextView tv_title;
    private Button btn_eventbus_send_main;
    private Button btn_eventbus_send_sticky;
    private TextView tv_eventbus_send_result;
    private boolean isFirstflag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);

        initView();//初始化控件
        initData();//设置控件
        setListener();//监听事件
    }

    private void setListener() {
        //主线程发送数据按钮点击事件处理
        btn_eventbus_send_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4.发送消息
                EventBus.getDefault().post(new MessageEvent("主线程发送过来的数据"));
                finish();
            }
        });

        //接收粘性事件数据按钮的点击处理
        btn_eventbus_send_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirstflag) {
                    isFirstflag = false;
                    //1.4注册
                    EventBus.getDefault().register(EventBusSendActivity.this);
                }
            }
        });
    }

    //1.3接收粘性事件
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void StickyEventBus(StickyEvent stickyEvent) {
        tv_eventbus_send_result.setText(stickyEvent.msg);
    }

    private void initData() {
        tv_title.setText("EventBus发送数据页面");
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_eventbus_send_main = (Button) findViewById(R.id.btn_eventbus_send_main);
        btn_eventbus_send_sticky = (Button) findViewById(R.id.btn_eventbus_send_sticky);
        tv_eventbus_send_result = (TextView) findViewById(R.id.tv_eventbus_send_result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //1.5解注册
        EventBus.getDefault().removeAllStickyEvents();//移除所有的粘性事件
        EventBus.getDefault().unregister(EventBusSendActivity.this);
    }
}
