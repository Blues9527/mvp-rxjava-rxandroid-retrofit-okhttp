package com.example.mvp;

import android.os.Bundle;
import android.widget.TextView;

import com.example.framework.base.BaseActivity;
import com.example.mvp.contract.Contract;
import com.example.mvp.model.Entity;
import com.example.mvp.presenter.CPresenter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.iContractView {

    private TextView tv;
    private Contract.iContractPresenter iPresenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        tv = findViewById(R.id.text);

        mPresenter = new CPresenter(this);


        iPresenter.getData(10, 1);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData(List<Entity.ResultsBean> result) {
        tv.setText(result.get(0).toString());
    }

    @Override
    public void setPresenter(Contract.iContractPresenter presenter) {
        this.iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }
}
