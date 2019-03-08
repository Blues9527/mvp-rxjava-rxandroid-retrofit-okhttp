package com.example.mvp.view;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.framework.utils.ScreenUtil;
import com.example.mvp.R;
import com.example.mvp.model.Entity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/3/6
 */

public class CViewHolder extends BaseViewHolder<Entity.ResultsBean> {

    private ImageView imageIv;
    private TextView tvDesc, tvAuthor, tvSource, tvPTime;

    public CViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_test);

        imageIv = $(R.id.iv_image);
        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvSource = $(R.id.tv_source);
        tvPTime = $(R.id.tv_publish_time);

    }

    @Override
    public void setData(Entity.ResultsBean data) {
        super.setData(data);

        imageIv.setLayoutParams(new LinearLayout.LayoutParams(ScreenUtil.getScreenWidth(), ScreenUtil.getScreenHeight() / 2));

        Glide.with(getContext()).load(data.getImages().get(0)).into(imageIv);
        tvDesc.setText(data.getDesc());
        tvAuthor.setText(String.format("作者：%s", data.getWho()));
        tvSource.setText(String.format("来自：%s", data.getSource()));
        tvPTime.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));
    }
}
