package com.zguming.orangeschool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zguming.orangeschool.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 订单
 * Created by Administrator on 2018/2/23 0023.
 */

public class OrderFragment extends Fragment {
    //全部
    @BindView(R.id.all)
    TextView all;
    //待支付
    @BindView(R.id.yet_pay)
    TextView yetPay;
    //已消费
    @BindView(R.id.already_consume)
    TextView alreadyConsume;
    //未评价
    @BindView(R.id.yet_assess)
    TextView yetAssess;
    Unbinder unbinder;
    @BindView(R.id.view_all)
    View viewAll;
    @BindView(R.id.view_pay)
    View viewPay;
    @BindView(R.id.view_consume)
    View viewConsume;
    @BindView(R.id.view_assess)
    View viewAssess;
    private OrderListFragment mOrderListFragment;
    private FragmentManager mFragmentManager;
    private String isClicked;//用于判断是否已被点击

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //默认fragment
        replaceFragment("全部");
    }


    private void replaceFragment(String content) {
        //判断当前fragment是否已显示，若是：取消重复显示，若否，显示fragment
        if (!Objects.equals(isClicked, content)) {
            mFragmentManager = getChildFragmentManager();
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            mOrderListFragment = OrderListFragment.newInstance(content);
            transaction.replace(R.id.order_list, mOrderListFragment);
            transaction.commit();
            isClicked=content;
        }

    }

    public static OrderFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.all, R.id.yet_pay, R.id.already_consume, R.id.yet_assess})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all:
                all.setTextColor(getResources().getColor(R.color.colorAccent));
                yetPay.setTextColor(getResources().getColor(R.color.default_text));
                alreadyConsume.setTextColor(getResources().getColor(R.color.default_text));
                yetAssess.setTextColor(getResources().getColor(R.color.default_text));
                viewAll.setVisibility(0);
                viewPay.setVisibility(4);
                viewConsume.setVisibility(4);
                viewAssess.setVisibility(4);
                replaceFragment("全部");
                break;
            case R.id.yet_pay:
                all.setTextColor(getResources().getColor(R.color.default_text));
                yetPay.setTextColor(getResources().getColor(R.color.colorAccent));
                alreadyConsume.setTextColor(getResources().getColor(R.color.default_text));
                yetAssess.setTextColor(getResources().getColor(R.color.default_text));
                viewAll.setVisibility(4);
                viewPay.setVisibility(0);
                viewConsume.setVisibility(4);
                viewAssess.setVisibility(4);
                replaceFragment("待付款");
                break;
            case R.id.already_consume:
                all.setTextColor(getResources().getColor(R.color.default_text));
                yetPay.setTextColor(getResources().getColor(R.color.default_text));
                alreadyConsume.setTextColor(getResources().getColor(R.color.colorAccent));
                yetAssess.setTextColor(getResources().getColor(R.color.default_text));
                viewAll.setVisibility(4);
                viewPay.setVisibility(4);
                viewConsume.setVisibility(0);
                viewAssess.setVisibility(4);
                replaceFragment("已消费");
                break;
            case R.id.yet_assess:
                all.setTextColor(getResources().getColor(R.color.default_text));
                yetPay.setTextColor(getResources().getColor(R.color.default_text));
                alreadyConsume.setTextColor(getResources().getColor(R.color.default_text));
                yetAssess.setTextColor(getResources().getColor(R.color.colorAccent));
                viewAll.setVisibility(4);
                viewPay.setVisibility(4);
                viewConsume.setVisibility(4);
                viewAssess.setVisibility(0);
                replaceFragment("待评价");
                break;
        }
    }
}
