package com.zguming.orangeschool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class CheckBill extends AppCompatActivity {


    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.ln_address)
    LinearLayout lnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_bill);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.login_btn, R.id.ln_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                break;
            case R.id.ln_address:
                Intent intent=new Intent(this,MyAddress.class);
                startActivity(intent);
                break;
        }
    }
}