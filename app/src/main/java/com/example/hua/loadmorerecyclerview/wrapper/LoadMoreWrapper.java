package com.example.hua.loadmorerecyclerview.wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hua.loadmorerecyclerview.R;

/**
 * Created by hua on 2017/12/8.
 */

public class LoadMoreWrapper extends RecyclerView.Adapter {

    private RecyclerView.Adapter mAdapter;

    //普通布局
    private int TYPE_ITEM = 1;

    //底部加载更多布局
    private int TYPE_FOOT = 2;

    //当前加载状态，默认为加载完成
    private int loadState = 2;
    //正在加载
    public final int LOADING = 1;
    //加载完成
    public final int LOADING_COMPLETE = 2;
    //没有更多数据，加载到底
    public final int LOADING_END = 3;

    public LoadMoreWrapper(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot_layout, parent, false);
            return new FootViewHolder(view);
        } else {
            return mAdapter.createViewHolder(parent, viewType);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (loadState) {
                case LOADING:
                    footViewHolder.mFootLayout.setVisibility(View.VISIBLE);
                    footViewHolder.mFootEnd.setVisibility(View.GONE);
                    break;
                case LOADING_COMPLETE:
                    footViewHolder.mFootLayout.setVisibility(View.INVISIBLE);
                    footViewHolder.mFootEnd.setVisibility(View.GONE);
                    break;
                case LOADING_END:
                    footViewHolder.mFootLayout.setVisibility(View.GONE);
                    footViewHolder.mFootEnd.setVisibility(View.VISIBLE);
                    break;
            }
        } else {
            mAdapter.onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为FooterView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mFootLayout;
        private TextView mFootEnd;

        public FootViewHolder(View view) {
            super(view);

            mFootEnd = view.findViewById(R.id.foot_end);
            mFootLayout = view.findViewById(R.id.foot_layout);

        }
    }

    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }
}
