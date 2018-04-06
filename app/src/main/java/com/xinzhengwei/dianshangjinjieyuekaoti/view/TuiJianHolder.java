package com.xinzhengwei.dianshangjinjieyuekaoti.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xinzhengwei.dianshangjinjieyuekaoti.R;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class TuiJianHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView tuijian_sdv;
    public TextView tuijian_title;
    public TextView tuijianprice;

    public TuiJianHolder(View itemView) {
        super(itemView);
        tuijian_sdv = itemView.findViewById(R.id.tuijian_sdv);
        tuijian_title = itemView.findViewById(R.id.tuijian_title);
        tuijianprice = itemView.findViewById(R.id.tuijianprice);
    }
}
