package com.zguming.orangeschool.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.activity.OrderDetail;
import com.zguming.orangeschool.bean.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单列表适配器
 * Created by Administrator on 2018/2/24 0024.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    LinearLayout lyOrder;
    private List<Order> data;
    private Context mContext;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        View orderView;
        @BindView(R.id.ve_order)
        View veOrder;
        @BindView(R.id.ly_order)
        LinearLayout lyOrder;
        @BindView(R.id.order_no)
        TextView orderNo;
        @BindView(R.id.order_time)
        TextView orderTime;
        @BindView(R.id.order_img)
        ImageView orderImg;
        @BindView(R.id.order_num)
        TextView orderNum;
        @BindView(R.id.order_price)
        TextView orderPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            orderView=itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public OrderListAdapter(Context mContext, List<Order> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_listview, parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Order order = data.get(position);
        String no = order.getNo();
        String time = order.getTime();
        String num = order.getNum();
        String price = order.getPrice();
        String imgUrl=order.getImgUrl();
        holder.orderNo.setText(no);
        holder.orderTime.setText(time);
        holder.orderNum.setText(num);
        holder.orderPrice.setText(price);
        Glide.with(mContext).load(imgUrl)
                .override(130, 130)
                .centerCrop()
                .into(holder.orderImg);
        //RecyclerView的item点击事件
        holder.orderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order=data.get(position);
                Toast.makeText(mContext,""+order.getNo(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mContext,OrderDetail.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
