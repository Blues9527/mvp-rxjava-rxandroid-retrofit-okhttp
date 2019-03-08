package com.example.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.framework.base.BaseActivity;
import com.example.mvp.contract.Contract;
import com.example.mvp.model.Entity;
import com.example.mvp.presenter.CPresenter;
import com.example.mvp.view.CViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.iContractView {

    private EasyRecyclerView contentErv;
    private Contract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<Entity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        contentErv = findViewById(R.id.rv_content);

        mPresenter = new CPresenter(this);


        iPresenter.getData(10, 1);

        new PagerSnapHelper().attachToRecyclerView(contentErv.getRecyclerView());
        contentErv.setLayoutManager(new LinearLayoutManager(this));
        contentErv.setAdapter(mAdapter = new RecyclerArrayAdapter<Entity.ResultsBean>(this) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CViewHolder(parent);
            }
        });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData(List<Entity.ResultsBean> result) {

        for (Entity.ResultsBean data : result) {
            mAdapter.add(data);
        }
        mAdapter.notifyDataSetChanged();
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
