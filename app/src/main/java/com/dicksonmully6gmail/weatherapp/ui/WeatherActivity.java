package com.dicksonmully6gmail.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

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
}
