package com.xinzhengwei.dianshangjinjieyuekaoti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.xinzhengwei.dianshangjinjieyuekaoti.model.Bean;
import com.xinzhengwei.dianshangjinjieyuekaoti.presenter.PresenterImp;
import com.xinzhengwei.dianshangjinjieyuekaoti.util.Constant;
import com.xinzhengwei.dianshangjinjieyuekaoti.util.GlideImageLoader;
import com.xinzhengwei.dianshangjinjieyuekaoti.view.IviewInter;
import com.xinzhengwei.dianshangjinjieyuekaoti.view.TuiJianAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements IviewInter {

    private RecyclerView miaosha;
    private RecyclerView tuijian;
    private Banner banner;
    private PresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miaosha = findViewById(R.id.miaosha);
        tuijian = findViewById(R.id.tuijian);
        banner = findViewById(R.id.banner);
        presenterImp = new PresenterImp(this);

        initData();
        //初始化一个Banner
        initBanner();

    }

    private void initBanner() {

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(2500);
        banner.setIndicatorGravity(BannerConfig.CENTER);


    }

    private void initData() {

        HashMap<String, String> map = new HashMap<>();
        presenterImp.getNetData(Constant.CATEGARY_URL,map);

    }

    @Override
    public void onSuccess(ResponseBody responseBody) {

        try {
            String json = responseBody.string();
            Bean bean = new Gson().fromJson(json, Bean.class);

            //首页轮播图
            List<Bean.DataBean> data = bean.getData();
            List<String> imageUrls = new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                imageUrls.add(data.get(i).getIcon());
            }
            banner.setImages(imageUrls);
            banner.start();

            //秒杀添加适配器
            miaosha.setAdapter(new MiaoShaAdapter(MainActivity.this,bean));
            miaosha.setLayoutManager(new LinearLayoutManager(MainActivity.this, OrientationHelper.HORIZONTAL,false));

            //给为你推荐添加适配器
            tuijian.setAdapter(new TuiJianAdapter(MainActivity.this,bean));
            tuijian.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
