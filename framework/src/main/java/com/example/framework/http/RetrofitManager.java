package com.example.framework.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class RetrofitManager {

    private static String BASE_URL = "";
    private static Retrofit.Builder mRetrofitBuilder;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static Retrofit getInstance() {
        if (null == mRetrofitBuilder) {
            synchronized (RetrofitManager.class) {
                mRetrofitBuilder = new Retrofit.Builder()
                        .client(OkHttpClientManager.getInstance())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            }
        }
        return mRetrofitBuilder
                .baseUrl(getBaseUrl())
                .build();
    }
}
