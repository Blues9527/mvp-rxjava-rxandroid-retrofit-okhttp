package com.example.mvp.presenter;

import android.util.Log;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.mvp.contract.Contract;
import com.example.mvp.model.CModel;
import com.example.mvp.model.Entity;

/**
 * User : Blues
 * Date : 2019/3/5
 * Time : 18:07
 * Email : huajianlan@rastar.com
 */

public class CPresenter extends RxPresenter implements Contract.iContractPresenter {

    private Contract.iContractModel iModel;

    private Contract.iContractView iView;

    public CPresenter(BaseView mView) {
        super(mView);
        iModel = new CModel();
        iView = (Contract.iContractView) mView;
    }

    @Override
    public void getData(int page, int limit) {
        subscribe(iModel.getData(page, limit, new HttpCallBack<Entity>() {
            @Override
            public void onSuccess(Entity data) {
                iView.setData(data.getResults());
            }

            @Override
            public void onFailure(String error) {
                Log.e("Blues", error);
            }
        }));
    }
}
