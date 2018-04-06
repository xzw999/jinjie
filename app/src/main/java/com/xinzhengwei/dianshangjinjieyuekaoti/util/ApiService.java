package com.xinzhengwei.dianshangjinjieyuekaoti.util;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by 辛政维 on 2018/3/15.
 */

public interface ApiService {

    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> doPost(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);


}
