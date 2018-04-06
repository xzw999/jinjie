package com.xinzhengwei.dianshangjinjieyuekaoti.model;

import com.xinzhengwei.dianshangjinjieyuekaoti.presenter.PresenterImp;
import com.xinzhengwei.dianshangjinjieyuekaoti.presenter.PresenterInter;
import com.xinzhengwei.dianshangjinjieyuekaoti.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/31.
 */

public class ModelImp implements ModelInter {

    private PresenterInter presenterInter;
    private Disposable d;

    public ModelImp(PresenterInter presenterInter) {
        this.presenterInter=presenterInter;
    }

    @Override
    public void getNetData(String url, Map<String, String> map) {

        RetrofitUtil.getService().doGet(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        ModelImp.this.d=d;
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        presenterInter.onSuccess(responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenterInter.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void unsubrice() {
    }
}
