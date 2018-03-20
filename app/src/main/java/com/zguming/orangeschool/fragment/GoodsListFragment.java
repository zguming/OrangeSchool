package com.zguming.orangeschool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zguming.orangeschool.R;
import com.zguming.orangeschool.adapter.GoodsListAdapter;
import com.zguming.orangeschool.bean.Goods;
import com.zguming.orangeschool.util.GlideImageLoader;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 商品列表
 * Created by Administrator on 2018/2/24 0024.
 */

public class GoodsListFragment extends Fragment {
    private List<Goods> goodsData = new ArrayList<>();
    //flowlayout数据
    private List<String> mVals=new ArrayList<>();
    Banner mBanner;
    @BindView(R.id.goods_recycler_view)
    XRecyclerView goodsRecyclerView;
    String agrs;
    View view;
    HomeFragment parentFragment;
    GoodsListAdapter goodsListAdapter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        agrs = bundle.getString("ARGS");
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parentFragment=((HomeFragment) (GoodsListFragment.this.getParentFragment()));
        initGoodsData();
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        goodsRecyclerView.setLayoutManager(layoutManager1);
        if(Objects.equals(agrs, "今日特惠")){
            View header= LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_goods_header,null);
            mBanner =  header.findViewById(R.id.banner);
            initBanner();
            goodsRecyclerView.addHeaderView(header);
        }else{
            View header= LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_goods_header2,null);
            initFlowlayout();
            setFlowlayout(header);
            goodsRecyclerView.addHeaderView(header);
        }
        //传入商品数组
        goodsListAdapter = new GoodsListAdapter(getActivity(), goodsData,parentFragment);
        goodsRecyclerView.setAdapter(goodsListAdapter);
        //禁用下拉刷新和加载更多功能
        goodsRecyclerView.setPullRefreshEnabled(false);
    }

    public void initGoodsData(){
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
        goodsData.add(new Goods("可口可乐","3","10"));
    }
    public void initBanner() {
        List<String> imagesa = new ArrayList<>();
        imagesa.add("http://img.zcool.cn/community/0166c756e1427432f875520f7cc838.jpg");
        imagesa.add("http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg");
        imagesa.add("http://img.zcool.cn/community/01fd2756e142716ac72531cbf8bbbf.jpg");
        imagesa.add("http://img.zcool.cn/community/0114a856640b6d32f87545731c076a.jpg");
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imagesa);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }
    public void initFlowlayout() {
        mVals.add("分类1");
        mVals.add("分类分类2");
        mVals.add("分类3");
        mVals.add("分类4");
        mVals.add("分类5");
        mVals.add("分类6");
    }
    private void setFlowlayout(View header) {
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        final com.zhy.view.flowlayout.TagFlowLayout mFlowLayout=header.findViewById(R.id.id_flowlayout);
        TagAdapter tagAdapter=new TagAdapter<String>(mVals)
        {
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) mInflater.inflate(R.layout.item_flowlayout,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        tagAdapter.setSelectedList(0);
        mFlowLayout.setAdapter(tagAdapter);
        //子分类点击事件
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                //传入商品数组
                goodsData.clear();
                initGoodsData();
                goodsListAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    public static GoodsListFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        GoodsListFragment fragment = new GoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
