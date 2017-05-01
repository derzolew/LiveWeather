package com.maxvi.max.liveweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxvi.max.liveweather.R;
import com.maxvi.max.liveweather.data.FakeData;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private final Context mContext;
    private final String[] mData;
    private final ForecastOnClickListener mForecastOnClickListener;

    public ForecastAdapter(final Context pContext,
                           final ForecastOnClickListener pForecastOnClickListener) {
        mData = FakeData.getData();
        mContext = pContext;
        mForecastOnClickListener = pForecastOnClickListener;
    }

    public interface ForecastOnClickListener {
        void onClick(String weatherData);
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.forecast_list_item, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, final int position) {
        holder.forecastTextView.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.length;
    }

    class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView forecastTextView;

        ForecastViewHolder(final View itemView) {
            super(itemView);
            forecastTextView = (TextView) itemView.findViewById(R.id.tv_list_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mForecastOnClickListener.onClick(forecastTextView.getText().toString());
        }
    }
}
