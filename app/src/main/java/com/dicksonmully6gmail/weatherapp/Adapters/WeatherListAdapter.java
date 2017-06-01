package com.dicksonmully6gmail.weatherapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.models.Weather;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dickson on 5/30/17.
 */

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }
    //WeatherViewHolder class inside WeatherListAdapter
    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.restaurantImageView) ImageView mWeatherImageView;//weather icon
        @Bind(R.id.restaurantNameTextView) TextView mNameTextView;//weather main type
        @Bind(R.id.categoryTextView) TextView mCategoryTextView;//description here
        @Bind(R.id.ratingTextView) TextView mRatingTextView;//date here

        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        //        creates an intent to navigate to our WeatherDetailActivity
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, WeatherDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("weathers", Parcels.wrap(mWeathers));
            mContext.startActivity(intent);
        }

        public void bindWeather(Weather weather) {
            Picasso.with(mContext)
                    .load(weather.getIcon())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mWeatherImageView);
            mNameTextView.setText(weather.getMainType());
            mCategoryTextView.setText(weather.getDescription());
            mRatingTextView.setText("Date: " + weather.getTime() );
        }


    }
}
