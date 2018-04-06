package com.xinzhengwei.dianshangjinjieyuekaoti.presenter;

import com.xinzhengwei.dianshangjinjieyuekaoti.model.ModelImp;
import com.xinzhengwei.dianshangjinjieyuekaoti.view.IviewInter;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class PresenterImp implements PresenterInter {

    private IviewInter iviewInter;
    private final ModelImp modelImp;

    public PresenterImp(IviewInter iviewInter) {
        this.iviewInter=iviewInter;
        modelImp = new ModelImp(this);
    }

    @Override
    public void getNetData(String url, Map<String, String> map) {
        modelImp.getNetData(url,map);
    }

    @Override
    public void unsubrice() {
        modelImp.unsubrice();
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        iviewInter.onSuccess(responseBody);
    }

    @Override
    public void onError(Throwable throwable) {
        iviewInter.onError(throwable);
    }
}
