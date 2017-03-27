package com.bawei.daning.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.daning.R;

import java.util.ArrayList;

/**
 * 作    者：云凯文
 * 时    间：2017/2/21
 * 描    述：RecyclerView的适配器
 * 修改时间：
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHodler> {

    private Context context;
    private ArrayList<String> datas;

    public MyRecyclerViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    //相当于getView方法中创建View和ViewHolder
    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item_recyclrtview, null);
        return new ViewHodler(itemView);
    }

    //数据和View绑定
    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        //根据位置得到对应的数据
        String str = datas.get(position);
        holder.tv_name.setText(str);
    }

    //得到总条数
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //添加数据
    public void addData(int position, String data) {
        datas.add(position, data);
        //刷新适配器
        notifyItemInserted(position);
    }

    //移除数据
    public void removeData(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView iv_icon;
        private TextView tv_name;

        public ViewHodler(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);

            //点击自条目的监听
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onItemClickListener) {
                        onItemClickListener.onItemClick(v, datas.get(getLayoutPosition()));
                    }
                }
            });

            //只点击图片的监听
            iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "我是图片" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    /**
     * 接口回调，点击事件
     * RecyclerView 的 item的监听事件
     */
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        //View:点击item的视图
        //data:点击得到的数据
        public void onItemClick(View view, String data);
    }

    //设置RecyclerView子条目的监听
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
