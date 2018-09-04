package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.entity.ItemListEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private Context mContext;
    private List<ItemListEntity> mList = new ArrayList<>();
    private MainActivity.ShowItemListener mListener;

    private Map<Integer,Boolean> checkedMap = new HashMap<>();
    public MenuAdapter(MainActivity.ShowItemListener listener, Context context) {
        this.mListener = listener;
        this.mContext = context;

    }

    public void addList(List<ItemListEntity> list){
        mList.addAll(list);
        for (int i = 0; i < mList.size(); i++) {
            checkedMap.put(i,mList.get(i).isChecked);
        }

    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.menu_item_list_layout,parent,false);
        return new MenuViewHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {

        holder.BindMenuView(mList.get(position));
        holder.mCheckBox.setOnCheckedChangeListener(null);//清掉监听器
        holder.mCheckBox.setChecked(checkedMap.get(position));
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        checkedMap.put(position,b);
        if(mListener!=null)
            mListener.notifyChanged(checkedMap);
            }
        });
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mContext.startActivity(new Intent(mContext, LinearChartActivity.class));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
