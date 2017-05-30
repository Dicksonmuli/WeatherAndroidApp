package com.dicksonmully6gmail.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dicksonmully6gmail.weatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.searchWeatherButton) Button mSearchWeatherButton;
    @Bind(R.id.locationEditText) Button mLocationEdidText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearchWeatherButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchWeatherButton) {
            String locaction = mLocationEdidText.getText().toString();
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            Intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
