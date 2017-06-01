package com.dicksonmully6gmail.weatherapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.models.Weather;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dickson on 6/1/17.
 */

public class WeatherDetailFragment extends Fragment implements View.OnClickListener {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    @Bind(R.id.weatherImageView)
    ImageView mImageLabel;//weather icon
    @Bind(R.id.weatherNameTextView)
    TextView mNameLabel;//weather main type
    @Bind(R.id.descriptionTextView)
    TextView mDescriptionLabel;//description here
    @Bind(R.id.dateTextView)
    TextView mDateLabel;//date here
    @Bind(R.id.tempTextView)
    TextView mTempLabel;


    //  restaurant object
    private Weather mRestaurant;

    public static WeatherDetailFragment newInstance(Weather weather) {
        //wrapping weather with parcels for serialization
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("weather", Parcels.wrap(weather));
        weatherDetailFragment.setArguments(args);
        return weatherDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
//        unwrapping restaurant on onCreate
        super.onCreate(savedInstanceState);
        mRestaurant = Parcels.unwrap(getArguments().getParcelable("weather"));
    }

    //    weather object used to set our ImageView and TextViews in onCreateView on onCreate view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.with(view.getContext())
                .load(mRestaurant.getIcon())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);

        mNameLabel.setText(mRestaurant.getMainType());
        mDescriptionLabel.setText(mRestaurant.getDescription());
        mDateLabel.setText(Double.toString(mRestaurant.getTime()) + "am/pm");

        return view;
    }
}

