package com.bawei.daning.eventbus.event;

/**
 * 作    者：云凯文
 * 时    间：2017/3/23
 * 描    述：
 * 修改时间：
 */

//1.1创建一个粘性事件类
public class StickyEvent {

    public String msg;

    public StickyEvent(String msg) {
        this.msg = msg;
    }
}
