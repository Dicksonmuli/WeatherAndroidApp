package com.dicksonmully6gmail.weatherapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dicksonmully6gmail.weatherapp.models.Weather;

import java.util.ArrayList;

/**
 * Created by dickson on 6/1/17.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Weather> mWeathers;

    public WeatherPagerAdapter(FragmentManager fm, ArrayList<Weather> weathers) {
        super(fm);
        mWeathers = weathers;
    }

    @Override
    public Fragment getItem(int position) {
        return WeathertDetailFragment.newInstance(mWeathers.get(position));
    }

    @Override
    public int getCount() {
        return mWeathers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mWeathers.get(position).getMainType();
    }
}
