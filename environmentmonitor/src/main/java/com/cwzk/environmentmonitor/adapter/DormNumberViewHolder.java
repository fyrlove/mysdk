package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.entity.ItemListEntity;

public class DormNumberViewHolder extends RecyclerView.ViewHolder {
    public TextView mDormNumber;
    private View mView;
    public DormNumberViewHolder(View itemView, Context context) {
        super(itemView);
        mView = itemView;
        mDormNumber = itemView.findViewById(R.id.tvDormNumber);
    }

    public void BindMenuView(String dormNumber){
        mDormNumber.setText(dormNumber);
    }
}
