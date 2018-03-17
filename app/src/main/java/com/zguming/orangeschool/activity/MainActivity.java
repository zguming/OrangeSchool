package com.zguming.orangeschool.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.fragment.HomeFragment;
import com.zguming.orangeschool.fragment.OrderFragment;
import com.zguming.orangeschool.fragment.UserFragment;

/**
 * Created by Administrator on 2018/2/15 0008.
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private HomeFragment mHomeFragment;
    private OrderFragment mOrderFragment;
    private UserFragment mUserFragment;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.setInActiveColor(R.color.ic_gray);
        bottomNavigationBar.setActiveColor(R.color.ic_blue);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_selected, "首页").setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.ic_home_normal)))
                .addItem(new BottomNavigationItem(R.drawable.ic_orders_selected, "订单").setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.ic_orders_normal)))
                .addItem(new BottomNavigationItem(R.drawable.ic_me_selected, "我的").setInactiveIcon(ContextCompat.getDrawable(this,R.drawable.ic_me_normal)))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }
    /**
     * 设置默认的
     */

    private void setDefaultFragment() {

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mHomeFragment = HomeFragment.newInstance("首页");
        transaction.add(R.id.layFrame, mHomeFragment);
        transaction.commit();
    }
    @Override
    public void onTabSelected(int position) {

        //开启事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragment(transaction);
        //fragment_order 用 add + show + hide 方式
        //只有第一次切换会创建fragment，再次切换不创建

        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("首页");
                    transaction.add(R.id.layFrame, mHomeFragment);
                }else{
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:
                if (mOrderFragment == null) {
                    mOrderFragment = OrderFragment.newInstance("订单");
                    transaction.add(R.id.layFrame, mOrderFragment);
                }else{
                    transaction.show(mOrderFragment);
                }
                break;
            case 2:
                if (mUserFragment == null) {
                    mUserFragment = UserFragment.newInstance("我的");
                    transaction.add(R.id.layFrame, mUserFragment);
                }else{
                    transaction.show(mUserFragment);
                }
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    /**
     * 隐藏当前fragment
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction){
        if (mHomeFragment != null){
            transaction.hide(mHomeFragment);
        }
        if (mOrderFragment != null){
            transaction.hide(mOrderFragment);
        }
        if (mUserFragment != null){
            transaction.hide(mUserFragment);
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}