package com.zguming.orangeschool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.adapter.OrderListAdapter;
import com.zguming.orangeschool.bean.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订单列表
 * Created by Administrator on 2018/2/24 0024.
 */

public class OrderListFragment extends Fragment {
    @BindView(R.id.order_rv)
    XRecyclerView orderRv;
    private List<Order> orderData = new ArrayList<>();
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String agrs = bundle.getString("ARGS");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initOrderData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        orderRv.setLayoutManager(layoutManager);
        //传入订单数据
        OrderListAdapter goodsAdapter = new OrderListAdapter(getActivity(), orderData);
        orderRv.setAdapter(goodsAdapter);
        //禁用下拉刷新和加载更多功能
        orderRv.setPullRefreshEnabled(false);
        View header= LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_order_header,null);
        orderRv.addHeaderView(header);
    }

    public void initOrderData() {
        orderData.add(new Order("1", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("2", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("3", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("4", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("5", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("6", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("7", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("8", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("9", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("10", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));
        orderData.add(new Order("11", "2018-1-1 12:30", "http://img1.imgtn.bdimg.com/it/u=2965524477,4194612590&fm=27&gp=0.jpg", "2", "6.00"));

    }

    public static OrderListFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
