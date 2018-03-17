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

import com.zguming.orangeschool.R;
import com.zguming.orangeschool.activity.GoodsDetail;
import com.zguming.orangeschool.bean.Goods;
import com.zguming.orangeschool.fragment.HomeFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品列表适配器
 * Created by Administrator on 2018/2/23 0023.
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.MyViewHolder> {
    private List<Goods> data;
    private Context mContext;
    HomeFragment parentFragment;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.goods_name)
        TextView goodsName;
        @BindView(R.id.goods_price)
        TextView goodsPrice;
        @BindView(R.id.goods_sales)
        TextView goodsSales;
        @BindView(R.id.gray_line)
        View grayLine;
        @BindView(R.id.iv_remove)
        ImageView ivRemove;
        @BindView(R.id.tv_goods_num)
        TextView tvGoodsNum;
        @BindView(R.id.iv_add)
        ImageView ivAdd;
        @BindView(R.id.goods_item)
        LinearLayout goodsItem;
        View goodsView;

        public MyViewHolder(View itemView) {
            super(itemView);
            goodsView = itemView;
            ButterKnife.bind(this, itemView);

        }
    }

    public GoodsListAdapter(Context mContext, List<Goods> data, HomeFragment parentFragment) {
        this.mContext = mContext;
        this.data = data;
        this.parentFragment = parentFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_listview, parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.goodsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GoodsDetail.class);
                mContext.startActivity(intent);
            }
        });
        myViewHolder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //XRecyclerView添加了两个header，因此要得到正确的position,需减去2
                int position = myViewHolder.getAdapterPosition() - 2;
                String str = myViewHolder.tvGoodsNum.getText().toString();
                int a = Integer.parseInt(str);
                a = a + 1;
                String strNum = "" + a;
                myViewHolder.tvGoodsNum.setText(strNum);
                myViewHolder.ivRemove.setVisibility(View.VISIBLE);
                myViewHolder.tvGoodsNum.setVisibility(View.VISIBLE);
                parentFragment.updataShoppingCart(0);
            }
        });
        myViewHolder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //XRecyclerView添加了两个header，因此要得到正确的position,需减去2
                int position = myViewHolder.getAdapterPosition() - 2;
                String str = myViewHolder.tvGoodsNum.getText().toString();
                int a = Integer.parseInt(str);
                a = a - 1;
                String strNum = "" + a;
                myViewHolder.tvGoodsNum.setText(strNum);
                if (a == 0) {
                    myViewHolder.ivRemove.setVisibility(View.INVISIBLE);
                    myViewHolder.tvGoodsNum.setVisibility(View.INVISIBLE);
                }
                parentFragment.updataShoppingCart(1);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Goods goods = data.get(position);
        String name = goods.getName();
        String price = goods.getPrice();
        String sales = goods.getSales();
        holder.goodsName.setText(name);
        holder.goodsPrice.setText(price);
        holder.goodsSales.setText(sales);
        if (position == 0) {
            holder.grayLine.setVisibility(View.VISIBLE);
        } else {
            holder.grayLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
