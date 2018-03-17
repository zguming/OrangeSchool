package com.zguming.orangeschool.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAddress extends AppCompatActivity {

    @BindView(R.id.tv_addaddress)
    TextView tvAddaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        ButterKnife.bind(this);
        Drawable draKk = getResources().getDrawable(R.drawable.buy_img_addaddress);
        draKk.setBounds(0, 0, 80, 80);
        tvAddaddress.setCompoundDrawables(draKk, null, null, null);

    }
}
