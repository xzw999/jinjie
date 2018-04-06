package com.xinzhengwei.dianshangjinjieyuekaoti;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.xinzhengwei.dianshangjinjieyuekaoti.model.Bean;
import com.xinzhengwei.dianshangjinjieyuekaoti.view.MiaoShaHolder;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class MiaoShaAdapter extends RecyclerView.Adapter<MiaoShaHolder> {
    private Bean bean;
    private Context context;

    public MiaoShaAdapter(Context context, Bean bean) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public MiaoShaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.miaosha_layout, null);
        MiaoShaHolder miaoShaHolder = new MiaoShaHolder(view);

        return miaoShaHolder;
    }

    @Override
    public void onBindViewHolder(MiaoShaHolder holder, int position) {

        String images = bean.getMiaosha().getList().get(position).getImages();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(split[0]);

        holder.miaosha_sdv.setImageURI(parse);

    }

    @Override
    public int getItemCount() {
        return bean.getMiaosha().getList().size();
    }
}
