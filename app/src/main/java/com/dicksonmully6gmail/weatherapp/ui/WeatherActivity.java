package com.dicksonmully6gmail.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.services.WeatherService;

import java.io.IOException;



import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dickson on 5/30/17.
 */

public class WeatherActivity extends AppCompatActivity{
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    public static final String TAG  = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

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
               try {
                   String jsonData = response.body().string();
                   Log.v(TAG, jsonData);
               }catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });
    }
}

