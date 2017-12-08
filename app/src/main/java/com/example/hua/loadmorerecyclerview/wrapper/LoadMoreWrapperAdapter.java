package com.example.hua.loadmorerecyclerview.wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hua.loadmorerecyclerview.Person;
import com.example.hua.loadmorerecyclerview.R;

import java.util.List;

/**
 * Created by hua on 2017/12/8.
 */

public class LoadMoreWrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Person> mPersons;

    public void setPersons(List<Person> mPersons) {
        this.mPersons = mPersons;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewHolder viewHolder = (RecyclerViewHolder) holder;
        viewHolder.mName.setText(mPersons.get(position).getName());
        viewHolder.mSex.setText(mPersons.get(position).getSex());
    }

    @Override
    public int getItemCount() {
        if (mPersons != null && mPersons.size() > 0) {
            return mPersons.size();
        } else {
            return 0;
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
}
