package com.xinzhengwei.dianshangjinjieyuekaoti.view;

import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public interface IviewInter {

    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);

}
