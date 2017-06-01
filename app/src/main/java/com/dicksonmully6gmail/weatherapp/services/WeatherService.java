package com.dicksonmully6gmail.weatherapp.services;

import com.dicksonmully6gmail.weatherapp.Constants;
import com.dicksonmully6gmail.weatherapp.models.Weather;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;


/**
 * Created by dickson on 5/30/17.
 */

    public class WeatherService {
        public static void searchWeather(String location, Callback callback) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
    //        HttpUrl class to construct the URL we'll send our request to
            HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
            String url = urlBuilder.build().toString() + Constants.YOUR_QUERY_PARAMETER + Constants.API_KEY_QUERY_PARAMETER + Constants.API_KEY;

    //        create request using the created url
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(callback);
        }
    //    parse JSON data and return a list of weather forecast days
    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weathers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject openWeatherMapJSON = new JSONObject(jsonData);
                JSONArray weatherListJSON = openWeatherMapJSON.getJSONArray("list");

                for (int i = 0; i < weatherListJSON.length(); i++) {
                    JSONObject weatherJSON = weatherListJSON.getJSONObject(i);
                  double time = weatherJSON.getDouble("dt_txt");
                    double temp = weatherJSON
                            .getJSONObject("main").getDouble("temp");
                    double humidity = weatherJSON
                            .getJSONObject("main").getDouble("humidity");
                    double windSpeed = weatherJSON
                            .getJSONObject("wind").getDouble("speed");
                    String mainType = weatherJSON
                            .getJSONObject("weather").getString("main");
                    String description = weatherJSON
                            .getJSONObject("weather").getString("description");
                    String icon = weatherJSON
                            .getJSONObject("weather").getString("icon");


                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}


