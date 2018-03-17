package com.zguming.orangeschool.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zguming.orangeschool.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class MyInformation extends AppCompatActivity {

    //popup窗口里的ListView 下拉列表
    private ListView mTypeLv;
    //popup窗口 下拉列表
    private PopupWindow typeSelectPopup;
    //模拟的假数据 下拉列表
    private List<String> testData;
    //数据适配器 下拉列表
    private ArrayAdapter<String> testDataAdapter;
    @BindView(R.id.tb_back)
    ImageView tbBack;
    @BindView(R.id.my_address)
    LinearLayout myAddress;
    @BindView(R.id.change_password)
    LinearLayout changePassword;
    @BindView(R.id.change_num)
    LinearLayout changeNum;
    @BindView(R.id.tv_sex)
    TextView tvSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        ButterKnife.bind(this);
        //设置popupWindow右边三角符号大小
        Drawable rightArrow = getResources().getDrawable(R.drawable.ic_arrows_down);
        rightArrow.setBounds(0, 0, 22, 22);
        tvSex.setCompoundDrawables(null, null, rightArrow, null);


    }

    @OnClick({R.id.tb_back, R.id.my_address, R.id.change_password, R.id.change_num, R.id.tv_sex})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tb_back:
                finish();
                break;
            case R.id.my_address:
                Intent intent = new Intent(this, MyAddress.class);
                startActivity(intent);
                break;
            case R.id.change_password:
                Intent intent2 = new Intent(this, ChangePassword.class);
                startActivity(intent2);
                break;
            case R.id.change_num:
                Intent intent3 = new Intent(this, ChangePhoneNum.class);
                startActivity(intent3);
                break;
            case R.id.tv_sex:
                //点击控件后显示popup窗口
                initSelectPopup();
                //使用isShowing()检查popup窗口是否在显示状态
                if (typeSelectPopup != null && !typeSelectPopup.isShowing()) {
                    typeSelectPopup.showAsDropDown(tvSex, 0, -1);
                }
                break;
        }
    }

    /**
     * 初始化popup窗口
     */
    private void initSelectPopup() {
        mTypeLv = new ListView(this);
        TestData();
        // 设置适配器
        testDataAdapter = new ArrayAdapter<String>(this, R.layout.popup_text_item, testData);
        mTypeLv.setAdapter(testDataAdapter);
        mTypeLv.setDividerHeight(0);//去掉listview分割线
        // 设置ListView点击事件监听
        mTypeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 在这里获取item数据
                String value = testData.get(position);
                // 把选择的数据展示对应的TextView上
                tvSex.setText(value);
                // 选择完后关闭popup窗口
                typeSelectPopup.dismiss();
            }
        });
        typeSelectPopup = new PopupWindow(mTypeLv, tvSex.getWidth(), ActionBar.LayoutParams.WRAP_CONTENT, true);
        // 取得popup窗口的背景图片
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.bg_filter_down);
        typeSelectPopup.setBackgroundDrawable(drawable);
        typeSelectPopup.setFocusable(true);
        typeSelectPopup.setOutsideTouchable(true);
        typeSelectPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 关闭popup窗口
                typeSelectPopup.dismiss();
            }
        });
    }

    /**
     * 模拟假数据
     */
    private void TestData() {
        testData = new ArrayList<>();
        testData.add("男");
        testData.add("女");
    }
}