package com.dicksonmully6gmail.weatherapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.models.Weather;

import java.util.ArrayList;

/**
 * Created by dickson on 5/30/17.
 */

public class WeatherListAdaper extends RecyclerView.Adapter<WeatherListAdaper.WeatherViewHolder> {
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdaper(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherListAdaper.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdaper.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }

}
