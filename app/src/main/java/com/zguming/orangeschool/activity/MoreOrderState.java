package com.zguming.orangeschool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.adapter.MoreOrderStateAdapter;
import com.zguming.orangeschool.adapter.OrderListAdapter;
import com.zguming.orangeschool.bean.OrderState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 更多订单状态
 * Created by Administrator on 2018/3/1 0001.
 */

public class MoreOrderState extends AppCompatActivity {
    private List<OrderState> orderStateData = new ArrayList<>();
    @BindView(R.id.tb_back)
    ImageView tbBack;
    @BindView(R.id.more_order_state_rv)
    XRecyclerView moreOrderStateRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_order_state);
        ButterKnife.bind(this);
        initOrderData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moreOrderStateRv.setLayoutManager(layoutManager);
        //传入订单数据
        MoreOrderStateAdapter moreOrderStateAdapter = new MoreOrderStateAdapter(this, orderStateData);
        moreOrderStateRv.setAdapter(moreOrderStateAdapter);
        //禁用下拉刷新和加载更多功能
        moreOrderStateRv.setPullRefreshEnabled(false);
    }
    public void initOrderData() {
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));
       orderStateData.add(new OrderState("2018-3-1","123456789"));

    }

    @OnClick(R.id.tb_back)
    public void onViewClicked() {
        finish();
    }
}
