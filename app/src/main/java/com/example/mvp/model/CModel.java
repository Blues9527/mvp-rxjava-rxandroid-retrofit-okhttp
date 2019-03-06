package com.example.mvp.model;

import com.example.framework.http.HttpCallBack;
import com.example.mvp.api.API;
import com.example.mvp.contract.Contract;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 18:01
 * Email : huajianlan@rastar.com
 */

public class CModel implements Contract.iContractModel {

    @Override
    public Subscription getData(int page, int limit, final HttpCallBack<Entity> callBack) {
        return API.getInstance().getData(page, limit, new Subscriber<Entity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(Entity entity) {
                callBack.onSuccess(entity);
            }
        });
    }
}
