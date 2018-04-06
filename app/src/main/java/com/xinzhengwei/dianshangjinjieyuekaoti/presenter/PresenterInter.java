package com.xinzhengwei.dianshangjinjieyuekaoti.presenter;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public interface PresenterInter {

    void getNetData(String url, Map<String,String> map);
    void unsubrice();

    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);

}
