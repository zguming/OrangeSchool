package com.zguming.orangeschool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zguming.orangeschool.R;
import com.zguming.orangeschool.bean.Goods;
import com.zguming.orangeschool.bean.Order;
import com.zguming.orangeschool.bean.OrderState;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 更多订单状态适配器
 * Created by Administrator on 2018/2/23 0023.
 */

public class MoreOrderStateAdapter extends RecyclerView.Adapter<MoreOrderStateAdapter.MyViewHolder> {
    private List<OrderState> data;
    private Context mContext;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.order_more_time)
        TextView orderMoreTime;
        @BindView(R.id.order_more_no)
        TextView orderMoreNo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public MoreOrderStateAdapter(Context mContext, List<OrderState> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_more, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrderState orderState = data.get(position);
        String time = orderState.getTime();
        String no = orderState.getNo();
        holder.orderMoreTime.setText(time);
        holder.orderMoreNo.setText(no);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
