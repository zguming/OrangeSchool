package com.zguming.orangeschool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
//客服中心
public class CustomerService extends AppCompatActivity {

    @BindView(R.id.tb_back)
    ImageView tbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tb_back)
    public void onViewClicked() {
        finish();
    }
}