package com.dicksonmully6gmail.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.Adapters.WeatherListAdapter;
import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.models.Weather;
import com.dicksonmully6gmail.weatherapp.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;


import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dickson on 5/30/17.
 */

public class WeatherListActivity extends AppCompatActivity{
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private WeatherListAdapter mAdapter;
    public ArrayList<Weather> mWeathers = new ArrayList<>();
    public static final String TAG  = WeatherListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Loading Weather At  :" + location);

        getWeather(location);
    }
    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.searchWeather(location, new Callback() {

           @Override
            public void onFailure(Call call, IOException e) {
               e.printStackTrace();
           }

           @Override
            public void onResponse(Call call, Response response) throws IOException {
              mWeathers = weatherService.processResults(response);

               WeatherListAdapter.this.runOnUiThread(new Runnable() {

                   @Override
                   public void run() {

                       mAdapter = new WeatherListAdapter(getApplicationContext(), mWeathers);
                       mRecyclerView.setAdapter(mAdapter);
                       RecyclerView.LayoutManager layoutManager =
                               new LinearLayoutManager(WeatherListAdapter.this);
                       mRecyclerView.setLayoutManager(layoutManager);
                       mRecyclerView.setHasFixedSize(true);

                   }

                });
            }
        });
    }
}