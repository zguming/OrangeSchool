package com.zguming.orangeschool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.adapter.NotifyAdapter;
import com.zguming.orangeschool.adapter.OrderListAdapter;
import com.zguming.orangeschool.bean.Notify;
import com.zguming.orangeschool.bean.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class SystemNotify extends AppCompatActivity {

    @BindView(R.id.tb_back)
    ImageView tbBack;
    @BindView(R.id.notify_rv)
    XRecyclerView notifyRv;
    private List<Notify> notifiesData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_notify);
        ButterKnife.bind(this);
        initNotifiesData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        notifyRv.setLayoutManager(layoutManager);
        //传入数据
        NotifyAdapter notifyAdapter = new NotifyAdapter(this, notifiesData);
        notifyRv.setAdapter(notifyAdapter);
        //禁用下拉刷新和加载更多功能
        notifyRv.setPullRefreshEnabled(false);
    }

    private void initNotifiesData() {
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));
        notifiesData.add(new Notify("2018-12-11","驶入驶入gfhrthgfhgfdhgfdhgfdhgfhgfdhgfdhgfdhhhhhhhhhhhhhhhhhhhhhhhhrthgfdhgfdhgfdhrtd","无为"));

    }

    @OnClick(R.id.tb_back)
    public void onViewClicked() {
        finish();
    }
}