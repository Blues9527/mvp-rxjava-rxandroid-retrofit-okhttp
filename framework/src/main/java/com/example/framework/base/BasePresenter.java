package com.example.framework.base;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 16:04
 * Email : huajianlan@rastar.com
 */

public interface BasePresenter {

    //订阅
    void subscribe(Subscription subscription);

    //取消订阅
    void unSubscribe();
}
