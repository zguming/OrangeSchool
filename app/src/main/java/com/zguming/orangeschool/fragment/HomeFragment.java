package com.zguming.orangeschool.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sunfusheng.marqueeview.MarqueeView;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.activity.CheckBill;
import com.zguming.orangeschool.activity.OrderDetail;
import com.zguming.orangeschool.adapter.CategoryAdapter;
import com.zguming.orangeschool.bean.GoodsNum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//首页
public class HomeFragment extends Fragment {
    //点击显示popupWindow 下拉列表 选择学校
    @BindView(R.id.tv_select_input)
    TextView tvSelectInput;
    @BindView(R.id.tv_shopping_cart_num)
    TextView tvShoppingCartNum;
    @BindView(R.id.ln_shopping)
    LinearLayout lnShopping;
    @BindView(R.id.iv_shopping_cart)
    ImageView ivShoppingCart;
    @BindView(R.id.tv_shopping)
    TextView tvShopping;
    //popup窗口里的ListView 下拉列表
    private ListView mTypeLv;
    //popup窗口 下拉列表
    private PopupWindow typeSelectPopup;
    //模拟的假数据 下拉列表
    private List<String> testData;
    //数据适配器 下拉列表
    private ArrayAdapter<String> testDataAdapter;
    //翻页公告
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    private Fragment currentFragment;//当前fragment
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private List<String> categroyData = new ArrayList<>();
    private GoodsListFragment mGoodsListFragment;
    private FragmentManager mFragmentManager;
    @BindView(R.id.category_recycler_view)
    XRecyclerView categoryRecyclerView;
    HomeFragment fragment;
    private int y=0;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置popupWindow右边三角符号大小
        Drawable rightArrow = getResources().getDrawable(R.drawable.ic_arrows_down);
        rightArrow.setBounds(0, 0, 28, 28);
        tvSelectInput.setCompoundDrawables(null, null, rightArrow, null);
        initCategroyData();//设置目录列表的数据，如糖果饮料
        initFragmentList();//初始化fragmentList
        setDefaultFragment();//设置默认的fragment 商品列表 可口可乐
        initMarqueeView();//初始化翻页公告
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        categoryRecyclerView.setLayoutManager(layoutManager);
        mFragmentManager = getChildFragmentManager();//fragment管理器
        //传入目录数据
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), categroyData, mFragmentManager, fragmentList);
        categoryRecyclerView.setAdapter(adapter);
        //禁用下拉刷新和加载更多功能
        categoryRecyclerView.setPullRefreshEnabled(false);
    }

    //模拟假数据 目录
    public void initCategroyData() {
        categroyData.add("今日特惠");
        categroyData.add("糖果面包");
        categroyData.add("零食饮料");
        categroyData.add("糖果面包");
        categroyData.add("零食饮料");
        categroyData.add("糖果面包");
        categroyData.add("零食饮料");
        categroyData.add("糖果面包");
    }

    public void initFragmentList() {
        for (int i = 0; i < categroyData.size(); i++) {
            fragmentList.add(GoodsListFragment.newInstance(categroyData.get(i)));
        }
    }

    //初始化翻页公告
    public void initMarqueeView() {
        List<String> info = new ArrayList<>();
        info.add("橙子校园招新啦~");
        info.add("首单立减16元 ！");
        info.add("招募院校合作伙伴");
        marqueeView.startWithList(info);
        //设置点击事件监听
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(getActivity(), String.valueOf(marqueeView.getPosition()) + ". " + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 解决marqueeView重影问题
     */
    @Override
    public void onHiddenChanged(boolean hidd) {
        if (hidd) {
            //隐藏时所作的事情
            marqueeView.stopFlipping();
        } else {
            //显示时所作的事情
            marqueeView.startFlipping();
        }
    }

    private void setDefaultFragment() {
        mFragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.goods_list, fragmentList.get(0));
        transaction.commit();
    }

    public static HomeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 初始化popup窗口
     */
    private void initSelectPopup() {
        mTypeLv = new ListView(getActivity());
        TestData();
        // 设置适配器
        testDataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.popup_text_item, testData);
        mTypeLv.setAdapter(testDataAdapter);
        mTypeLv.setDividerHeight(0);//去掉listview分割线
        // 设置ListView点击事件监听
        mTypeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 在这里获取item数据
                String value = testData.get(position);
                // 把选择的数据展示对应的TextView上
                tvSelectInput.setText(value);
                // 选择完后关闭popup窗口
                typeSelectPopup.dismiss();
            }
        });
        typeSelectPopup = new PopupWindow(mTypeLv, tvSelectInput.getWidth(), ActionBar.LayoutParams.WRAP_CONTENT, true);
        // 取得popup窗口的背景图片
        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.bg_filter_down);
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
        testData.add("机械学院");
        testData.add("护理学院");
    }

    public void updataShoppingCart(int i) {
        String str = tvShoppingCartNum.getText().toString();
        int a = Integer.parseInt(str);
        switch (i) {
            case 0:
                a = a + 1;
                String strNum = "" + a;
                tvShoppingCartNum.setText(strNum);
                tvShoppingCartNum.setVisibility(View.VISIBLE);
                break;
            case 1:
                a = a - 1;
                String strNum2 = "" + a;
                tvShoppingCartNum.setText(strNum2);
                if (a == 0) {
                    tvShoppingCartNum.setVisibility(View.INVISIBLE);
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.tv_select_input, R.id.iv_shopping_cart, R.id.tv_shopping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_select_input:
                //点击控件后显示popup窗口
                initSelectPopup();
                //使用isShowing()检查popup窗口是否在显示状态
                if (typeSelectPopup != null && !typeSelectPopup.isShowing()) {
                    typeSelectPopup.showAsDropDown(tvSelectInput, 0, -1);
                }
                break;
            case R.id.iv_shopping_cart:
                String str = tvShoppingCartNum.getText().toString();
                int a = Integer.parseInt(str);
                if (a != 0&&y==0) {
                    lnShopping.setVisibility(View.VISIBLE);
                    y=1;
                }else{
                    lnShopping.setVisibility(View.GONE);
                    y=0;
                }
                break;
            case R.id.tv_shopping:
                //lnShopping.setVisibility(View.GONE);
                Intent intent=new Intent(getActivity(),CheckBill.class);
                getActivity().startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        GoodsNum goodsNum=new GoodsNum();
        int goodsDetailNum=goodsNum.getNum();
        int a=Integer.valueOf(tvShoppingCartNum.getText().toString());
        a = a + goodsDetailNum;
        String strNum = "" + a;
        tvShoppingCartNum.setText(strNum);
        //判断购物车商品数量是否为0，不为0则设为可见
        if(!(a ==0)){
            tvShoppingCartNum.setVisibility(View.VISIBLE);
        }
    }
}