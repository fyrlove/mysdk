package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.entity.ItemListEntity;
import com.ydky.vuandroidadsdk.adutil.ImageLoaderManager;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView mTitle;
    private TextView mContent;
    private ImageView mImageView;
    private View mView;
    public MainViewHolder(View itemView,Context context) {
        super(itemView);
        this.mContext = context;
        mView = itemView;

        mTitle = itemView.findViewById(R.id.tvTitle);
        mContent = itemView.findViewById(R.id.tvContent);
        mImageView = itemView.findViewById(R.id.ivImage);
    }

    public void BindView(ItemListEntity entity){
        mTitle.setText(entity.title);
        if(entity.title.equals("经纬度")){
            mContent.setTextSize(12);
        }
        mContent.setText(entity.content);
        mImageView.setBackground(mContext.getResources().getDrawable(entity.imgPath));
        //ImageLoaderManager.getInstance(mContext).displayImage(mImageView,mContext.getResources().getDrawable(entity.imgPath));
    }
}
