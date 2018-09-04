package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.entity.ItemListEntity;

public class MenuViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView mTitle;
    public CheckBox mCheckBox;
    private ImageView mImageView;
    private View mView;
    public MenuViewHolder(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        mView = itemView;

        mTitle = itemView.findViewById(R.id.tvTitle);
        mImageView = itemView.findViewById(R.id.ivImage);
        mCheckBox = itemView.findViewById(R.id.checkbox);
    }

    public void BindMenuView(ItemListEntity entity){
        mTitle.setText(entity.title);
        mImageView.setBackground(mContext.getResources().getDrawable(entity.imgPath));
    }
}
