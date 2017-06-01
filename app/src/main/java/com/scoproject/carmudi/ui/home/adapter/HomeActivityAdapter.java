package com.scoproject.carmudi.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.scoproject.carmudi.R;
import com.scoproject.carmudi.data.ResultData;
import com.scoproject.carmudi.helper.AppHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.ViewHolder> {
    private Context mContext;
    private List<ResultData>  mResultData = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public HomeActivityAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<ResultData> resultDatas){
        mResultData = resultDatas;
        notifyDataSetChanged();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_car, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultData data = mResultData.get(position);
        String[] finalPrice = data.carsDataList.price.split("\\.");
        Log.d(getClass().getName(), finalPrice[0]);
        holder.mCarName.setText(data.carsDataList.originalName);
        holder.mCarBrand.setText(data.carsDataList.brand);
        holder.mCarPrice.setText(AppHelper.CurrencyHelper(Long.valueOf(finalPrice[0])));
        Glide.with(mContext)
                .load(data.imageDataList.get(0).url)
                .placeholder(R.color.cardview_shadow_end_color)
                .into(holder.mCarThumb);
    }

    @Override
    public int getItemCount() {
        return mResultData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mCarName;
        TextView mCarBrand;
        TextView mCarPrice;
        ImageView mCarThumb;
        public ViewHolder(View itemView) {
            super(itemView);
            mCarName = (TextView) itemView.findViewById(R.id.item_car_name);
            mCarBrand = (TextView) itemView.findViewById(R.id.item_car_brand);
            mCarPrice = (TextView) itemView.findViewById(R.id.item_car_price);
            mCarThumb = (ImageView) itemView.findViewById(R.id.item_car_thumb);
        }
    }
}
