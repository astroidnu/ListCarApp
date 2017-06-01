package com.scoproject.carmudi.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scoproject.carmudi.R;

/**
 * Created by ibnumuzzakkir on 6/2/17.
 */

public class HomeSortingAdapter extends RecyclerView.Adapter<HomeSortingAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public HomeSortingAdapter(Context context){
        mContext = context;
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
