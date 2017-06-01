package com.scoproject.carmudi.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.scoproject.carmudi.data.ResultData;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.ViewHolder> {
    private Context mContext;
    private List<ResultData> mResultData;
    public HomeActivityAdapter(Context context){
        mContext = context;
    }

    public void setData(List<ResultData> resultDatas){
        mResultData = resultDatas;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mResultData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
