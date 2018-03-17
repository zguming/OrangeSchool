package com.zguming.orangeschool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zguming.orangeschool.view.CustomeGridView;
import com.zguming.orangeschool.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class GoodsDetail extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.iv_remove2)
    ImageView ivRemove2;
    @BindView(R.id.tv_goods_num2)
    TextView tvGoodsNum2;
    @BindView(R.id.iv_add2)
    ImageView ivAdd2;
    @BindView(R.id.gridView)
    CustomeGridView gridView;
    //定义以及初始化数据
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
            , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String[] iconName = {"¥ 1+", "¥ 1+", "¥ 1+", "¥ 1+", "¥ 1+"
            , "¥ 1+", "¥ 1+", "¥ 1+"};
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        //实例化gridView
        gridView = findViewById(R.id.gridView);
        /*
        1.准备数据源； 2.新建适配器； 3.GridView加载适配器；4.GridView配置事件监听器
         */
        dataList = new ArrayList<>();
        adapter = new SimpleAdapter(this, getData(), R.layout.gridview_item, new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,"我是",Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.iv_remove2, R.id.iv_add2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_remove2:
                String str1 = tvGoodsNum2.getText().toString();
                int a1 = Integer.parseInt(str1);
                a1=a1-1;
                String strNum1=""+a1;
                tvGoodsNum2.setText(strNum1);
                if(a1==0){
                    ivRemove2.setVisibility(View.INVISIBLE);
                    tvGoodsNum2.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.iv_add2:
                String str = tvGoodsNum2.getText().toString();
                int a = Integer.parseInt(str);
                a=a+1;
                String strNum=""+a;
                tvGoodsNum2.setText(strNum);
                ivRemove2.setVisibility(View.VISIBLE);
                tvGoodsNum2.setVisibility(View.VISIBLE);
                break;
        }
    }
}
