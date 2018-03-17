package com.zguming.orangeschool.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zguming.orangeschool.R;
import com.zguming.orangeschool.activity.CustomerService;
import com.zguming.orangeschool.activity.MyAddress;
import com.zguming.orangeschool.activity.Setting;
import com.zguming.orangeschool.activity.SystemNotify;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的
 * Created by Administrator on 2018/2/23 0023.
 */

public class UserFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.setting)
    ImageView setting;
    @BindView(R.id.rl_service)
    LinearLayout rlService;
    @BindView(R.id.iv_notify)
    ImageView ivNotify;
    @BindView(R.id.my_address)
    LinearLayout myAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static UserFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.setting, R.id.rl_service, R.id.iv_notify, R.id.my_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting:
                Intent intent = new Intent(getActivity(), Setting.class);
                startActivity(intent);
                break;
            case R.id.rl_service:
                Intent intent2 = new Intent(getActivity(), CustomerService.class);
                startActivity(intent2);
                break;
            case R.id.iv_notify:
                Intent intent3 = new Intent(getActivity(), SystemNotify.class);
                startActivity(intent3);
                break;
            case R.id.my_address:
                Intent intent4 = new Intent(getActivity(), MyAddress.class);
                startActivity(intent4);
                break;
        }
    }
    
}
