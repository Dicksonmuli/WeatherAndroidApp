package com.dicksonmully6gmail.weatherapp.services;

import com.dicksonmully6gmail.weatherapp.Constants;
import com.squareup.picasso.Request;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;


/**
 * Created by dickson on 5/30/17.
 */

public class WeatherService {
    public static void searchWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
//        HttpUrl class to construct the URL we'll send our request to
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString() + location + Constants.API_KEY_QUERY_PARAMETER + Constants.API_KEY;

//        create request using the created url
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}

