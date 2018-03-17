package com.zguming.orangeschool.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zguming.orangeschool.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 目录列表适配器
 * Created by Administrator on 2018/2/23 0023.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<String> data;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FragmentTransaction transaction;
    private List<Fragment> fragmentList;
    private Fragment currentFragment;
    private int thisPosition = 0;//控件是否被点击,如果被点击，改变值，控件根据值改变自身颜色

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.category_space)
        View categorySpace;
        @BindView(R.id.category_bg)
        LinearLayout categoryBg;
        private View categoryView;

        public MyViewHolder(View itemView) {
            super(itemView);
            categoryView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public CategoryAdapter(Context mContext, List<String> data, FragmentManager mFragmentManager, List<Fragment> fragmentList) {
        this.mContext = mContext;
        this.data = data;
        this.mFragmentManager = mFragmentManager;
        this.fragmentList=fragmentList;
        currentFragment=fragmentList.get(0);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_listview_item, parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        //RecyclerView的item点击事件 点击切换fragment
        myViewHolder.categoryBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //XRecyclerView默认添加了一个header，因此要得到正确的position,需减去1
                int position = myViewHolder.getAdapterPosition() - 1;
                thisPosition = position;
                String category = data.get(position);
                Fragment to=fragmentList.get(position);
                switchContent(currentFragment, to);
                currentFragment=to;
                notifyDataSetChanged();//刷新
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String category = data.get(position);
        holder.tvCategory.setText(category);
        if (position == 0) {
            holder.categorySpace.setVisibility(View.VISIBLE);
            holder.tvCategory.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
        if (thisPosition == position) {
            holder.categoryBg.setBackgroundResource(R.color.purple);
        } else {
            holder.categoryBg.setBackgroundResource(R.color.white);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //用add show hide方式切换fragment
    private void switchContent(Fragment from, Fragment to) {
        transaction = mFragmentManager.beginTransaction();
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.goods_list, to).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }
}
