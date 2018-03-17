package com.zguming.orangeschool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单详情
 * Created by Administrator on 2018/2/27 0027.
 */

public class OrderDetail extends AppCompatActivity {
    @BindView(R.id.more_state)
    LinearLayout moreState;
    @BindView(R.id.tb_back)
    ImageView tbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tb_back, R.id.more_state})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tb_back:
                finish();
                break;
            case R.id.more_state:
                Intent intent = new Intent(this, MoreOrderState.class);
                startActivity(intent);
                break;
        }
    }
}
