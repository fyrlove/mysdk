package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DormNumberAdapter extends RecyclerView.Adapter<DormNumberViewHolder> {
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public DormNumberAdapter(Context context) {
        this.mContext = context;

    }

    public void addList(List<String> list){
        mList.addAll(list);
    }

    @Override
    public DormNumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dorm_number_layout,parent,false);
        return new DormNumberViewHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(DormNumberViewHolder holder, final int position) {
            holder.BindMenuView(mList.get(position));
        holder.mDormNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title","男生宿舍"+mList.get(position));
                intent.setClass(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
