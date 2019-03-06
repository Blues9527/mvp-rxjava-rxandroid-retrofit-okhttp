package com.example.mvp.contract;

import com.example.framework.base.BasePresenter;
import com.example.framework.base.BaseView;
import com.example.framework.http.HttpCallBack;
import com.example.mvp.model.Entity;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 17:37
 * Email : huajianlan@rastar.com
 */

public interface Contract {
    interface iContractView extends BaseView<iContractPresenter> {

        void setData(List<Entity.ResultsBean> result);

    }

    interface iContractPresenter extends BasePresenter {

        void getData(int page, int limit);

    }

    interface iContractModel {

        Subscription getData(int page, int limit, HttpCallBack<Entity> callBack);

    }
}
