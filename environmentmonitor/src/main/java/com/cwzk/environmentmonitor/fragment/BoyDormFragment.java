package com.cwzk.environmentmonitor.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.adapter.DormNumberAdapter;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import java.util.ArrayList;
import java.util.List;

public class BoyDormFragment extends Fragment {
    RecyclerView recyclerView;

    public BoyDormFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static BoyDormFragment newInstance() {
        BoyDormFragment fragment = new BoyDormFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boy_dorm_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        final RecyclerAdapter adapter = new RecyclerAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = 5;
            }
        });
        //fill with empty objects
        final List<Object> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 4; j++) {
                list.add("男生宿舍"+i+"栋"+j+"楼");
            }
        }
        adapter.setItems(list);



    }

    public final static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

        private final List<Object> list = new ArrayList<>();

        private final ExpansionLayoutCollection expansionsCollection = new ExpansionLayoutCollection();

        private Context mContext;
        public RecyclerAdapter(Context context) {
            this.mContext = context;
            expansionsCollection.openOnlyOne(true);
        }

        @Override
        public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return RecyclerHolder.buildFor(parent);
        }

        @Override
        public void onBindViewHolder(RecyclerAdapter.RecyclerHolder holder, int position) {
            holder.bind(list.get(position));

            List<String> dormList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                    dormList.add(i+"-00"+(i+1));
            }
            DormNumberAdapter dormNumberAdapter = new DormNumberAdapter(mContext);
            final GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,3);
            holder.dormRecyclerView.setLayoutManager(gridLayoutManager);
            holder.dormRecyclerView.setNestedScrollingEnabled(false);
            holder.dormRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                    int spanSize = layoutParams.getSpanSize();
                    int spanIndex = layoutParams.getSpanIndex();
                    outRect.top = 10;
                    if(spanSize!=gridLayoutManager.getSpanCount()){
                            outRect.left =5;
                            outRect.right = 5;
                    }
                }
            });
            dormNumberAdapter.addList(dormList);
            holder.dormRecyclerView.setAdapter(dormNumberAdapter);
            dormNumberAdapter.notifyDataSetChanged();
            holder.tvDormTitle.setText(list.get(position).toString());
            expansionsCollection.add(holder.getExpansionLayout());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void setItems(List<Object> items) {
            this.list.addAll(items);
            notifyDataSetChanged();
        }

        public final static class RecyclerHolder extends RecyclerView.ViewHolder {

            private static final int LAYOUT = R.layout.expansion_panel_recycler_cell;

            ExpansionLayout expansionLayout;
            TextView tvDormTitle;
            RecyclerView dormRecyclerView;
            public static RecyclerHolder buildFor(ViewGroup viewGroup){
                return new RecyclerHolder(LayoutInflater.from(viewGroup.getContext()).inflate(LAYOUT, viewGroup, false));
            }

            public RecyclerHolder(View itemView) {
                super(itemView);
                tvDormTitle = itemView.findViewById(R.id.tvDormTitle);
                expansionLayout = itemView.findViewById(R.id.expansionLayout);
                dormRecyclerView = itemView.findViewById(R.id.dormRecyclerView);
            }

            public void bind(Object object){
                expansionLayout.collapse(false);
            }

            public ExpansionLayout getExpansionLayout() {
                return expansionLayout;
            }
        }
    }


}
