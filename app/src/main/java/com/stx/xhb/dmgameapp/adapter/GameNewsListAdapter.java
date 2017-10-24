package com.stx.xhb.dmgameapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.stx.xhb.dmgameapp.R;
import com.stx.xhb.dmgameapp.WebDetailsActivity;
import com.stx.xhb.dmgameapp.entity.NewsListEntity;

import java.util.List;

/**
 * Author : jxnk25
 * Time: 2017/10/24 0024
 * Email:xhb_199409@163.com
 * Email:xhb_199409@163.com
 * Github:https://github.com/xiaohaibin/
 * Drscribe:
 */

public class GameNewsListAdapter extends BaseQuickAdapter<NewsListEntity.ChannelEntity.HtmlEntity,BaseViewHolder> {
    private Context mContext;
    public GameNewsListAdapter(Context context) {
        super(R.layout.list_item_news);
        this.mContext=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final NewsListEntity.ChannelEntity.HtmlEntity data) {
        helper.setText(R.id.title,data.getTitle());
        helper.setText(R.id.date,data.getSenddate());
        ImageView imageView=helper.getView(R.id.iv);
        List<List<String>> litpic = data.getLitpic();
        if (litpic != null && !litpic.isEmpty()) {
            List<String> stringList = litpic.get(0);
            if (stringList != null && !stringList.isEmpty()) {
                Glide.with(mContext).load(stringList.get(0)).into(imageView);
            }
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebDetailsActivity.start(mContext, data.getArcurl());
            }
        });
    }
}
