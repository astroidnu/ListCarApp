package com.scoproject.carmudi.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scoproject.carmudi.R;
import com.scoproject.carmudi.ui.home.HomePresenter;
import com.scoproject.carmudi.ui.home.HomeView;

/**
 * Created by ibnumuzzakkir on 6/2/17.
 */

public class HomeSortingAdapter extends RecyclerView.Adapter<HomeSortingAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private HomePresenter mHomePresenter;

    public HomeSortingAdapter(Context context, HomePresenter homePresenter){
        mContext = context;
        mHomePresenter = homePresenter;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_sorting, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String sortTitle = mContext.getResources().getStringArray(R.array.sorting_list)[position];
        holder.mSortingTitle.setText(sortTitle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomePresenter.loadSortData(sortTitle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContext.getResources().getStringArray(R.array.sorting_list).length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mSortingTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mSortingTitle = (TextView) itemView.findViewById(R.id.item_sorting_title);
        }
    }
}
