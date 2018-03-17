package com.zguming.orangeschool.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2018/2/2 0002.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        //注意：图片加载器由自己选择，这里不限制，只是提供几种使用方法
        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);
    }

}