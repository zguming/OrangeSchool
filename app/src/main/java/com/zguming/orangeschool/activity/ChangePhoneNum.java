package com.zguming.orangeschool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class ChangePhoneNum extends AppCompatActivity {


    @BindView(R.id.tb_back)
    ImageView tbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone_num);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tb_back)
    public void onViewClicked() {
        finish();
    }
}