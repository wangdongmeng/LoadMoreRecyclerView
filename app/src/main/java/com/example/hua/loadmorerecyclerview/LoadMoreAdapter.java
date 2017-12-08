package com.example.hua.loadmorerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hua on 2017/12/7.
 */

public class LoadMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;

    private List<Person> mPersons;

    //普通布局
    private final int TYPE_ITEM = 1;
    //上拉加载更多的布局
    private final int TYPE_FOOT = 2;

    //默认加载完成
    private int loadState = 2;

    //正在加载
    public final int LOADING = 1;
    //加载完成
    public final int LOADING_COMPLETE = 2;
    //加载到底
    public final int LOADING_END = 3;


    public LoadMoreAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    public void setPersons(List<Person> mPersons) {
        this.mPersons = mPersons;
        notifyDataSetChanged();
    }

    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_layout,null);
//            View view = inflater.inflate(R.layout.item_person_layout, parent,false);
            return new RecyclerViewHolder(view);
        } else if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot_layout, null);
//            View view = inflater.inflate(R.layout.item_foot_layout,null);
            return new FootViewHolder(view);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof RecyclerViewHolder){
                RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) holder;
                recyclerViewHolder.mName.setText(mPersons.get(position).getName());
                recyclerViewHolder.mSex.setText(mPersons.get(position).getSex());
            }else if (holder instanceof FootViewHolder){
                FootViewHolder footViewHolder = (FootViewHolder) holder;
                switch (loadState){
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
            }
    }

    @Override
    public int getItemCount() {
        if (mPersons != null && mPersons.size() > 0){
            return mPersons.size() + 1;
        }else {
            return 0;
        }

    }

    @Override
    public int getItemViewType(int position) {
        //最后一个设置为foot
        if (position + 1 == getItemCount()){
            return TYPE_FOOT;
        }else {
            return TYPE_ITEM;
        }
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mSex;

        public RecyclerViewHolder(View view) {
            super(view);

            mName = view.findViewById(R.id.item_name);
            mSex = view.findViewById(R.id.item_sex);
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
}
