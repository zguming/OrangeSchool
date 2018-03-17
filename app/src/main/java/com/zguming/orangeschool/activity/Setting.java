package com.zguming.orangeschool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.zguming.orangeschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class Setting extends AppCompatActivity {

    @BindView(R.id.modify_personal_information)
    LinearLayout modifyPersonalInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.modify_personal_information)
    public void onViewClicked() {
        Intent intent=new Intent(this,MyInformation.class);
        startActivity(intent);
    }
}