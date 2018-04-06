package com.xinzhengwei.dianshangjinjieyuekaoti.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xinzhengwei.dianshangjinjieyuekaoti.MainActivity;
import com.xinzhengwei.dianshangjinjieyuekaoti.R;
import com.xinzhengwei.dianshangjinjieyuekaoti.model.Bean;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianHolder> {
    private Bean bean;
    private Context context;

    public TuiJianAdapter(Context context, Bean bean) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public TuiJianHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tuijian_item_layout, null);
        TuiJianHolder tuiJianHolder = new TuiJianHolder(view);
        return tuiJianHolder;
    }

    @Override
    public void onBindViewHolder(TuiJianHolder holder, int position) {

        Bean.TuijianBean.ListBean listBean = bean.getTuijian().getList().get(position);
        holder.tuijian_title.setText(listBean.getTitle());
        holder.tuijianprice.setText("￥"+listBean.getBargainPrice());
        String[] split = listBean.getImages().split("\\|");
        holder.tuijian_sdv.setImageURI(Uri.parse(split[0]));

    }

    @Override
    public int getItemCount() {
        return bean.getTuijian().getList().size();
    }
}
