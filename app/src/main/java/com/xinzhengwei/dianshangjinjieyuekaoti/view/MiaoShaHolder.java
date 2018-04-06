package com.xinzhengwei.dianshangjinjieyuekaoti.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xinzhengwei.dianshangjinjieyuekaoti.R;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class MiaoShaHolder extends RecyclerView.ViewHolder{

    public SimpleDraweeView miaosha_sdv;

    public MiaoShaHolder(View itemView) {
        super(itemView);
        miaosha_sdv = itemView.findViewById(R.id.miaosha_sdv);
    }
}
