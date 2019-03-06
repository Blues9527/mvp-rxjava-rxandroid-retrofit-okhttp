package com.example.mvp.api;

import com.example.framework.http.RetrofitManager;
import com.example.framework.utils.RxUtil;
import com.example.mvp.model.Entity;
import com.example.mvp.request.ContractRequest;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 17:43
 * Email : huajianlan@rastar.com
 */

public class API {

    private static volatile API instance;

    private API() {
    }

    public static API getInstance() {
        RetrofitManager.setBaseUrl("http://gank.io");
        if (null == instance) {
            synchronized (API.class) {
                if (null == instance) {
                    instance = new API();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int page, int limit, Subscriber<Entity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(ContractRequest.class).getData(page, limit);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
