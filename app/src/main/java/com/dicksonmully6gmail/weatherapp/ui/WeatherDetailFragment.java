package com.dicksonmully6gmail.weatherapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.dicksonmully6gmail.weatherapp.R;
import com.dicksonmully6gmail.weatherapp.models.Weather;

import butterknife.Bind;

/**
 * Created by dickson on 6/1/17.
 */

public class WeatherDetailFragment extends Fragment implements View.OnClickListener{
private static final int MAX_WIDTH = 400;
private static final int MAX_HEIGHT = 300;
@Bind(R.id.weatherImageView) ImageView mWeatherImageView;//weather icon
@Bind(R.id.weatherNameTextView) TextView mNameTextView;//weather main type
@Bind(R.id.descriptionTextView) TextView mDescriptionTextView;//description here
@Bind(R.id.dateTextView) TextView mDateTextView;//date here
@Bind(R.id.tempTextView)
TextView mWebsiteLabel;


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

//    restaurant object used to set our ImageView and TextViews in onCreateView on onCreate view
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        // Inflating the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.with(view.getContext())
        .load(mRestaurant.getImageUrl())
        .resize(MAX_WIDTH, MAX_HEIGHT)
        .centerCrop()
        .into(mImageLabel);

        mNameLabel.setText(mRestaurant.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", mRestaurant.getCategories()));
        mRatingLabel.setText(Double.toString(mRestaurant.getRating()) + "/5");
        mPhoneLabel.setText(mRestaurant.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mRestaurant.getAddress()));

        mWebsiteLabel.setOnClickListener( this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener( this);
        return view;
        }
//    implicit intent
@Override
public void onClick(View v) {
        if (v == mWebsiteLabel) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
        Uri.parse(mRestaurant.getWebsite()));
        startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
        Uri.parse("tel:" + mRestaurant.getPhone()));
        startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,
        Uri.parse("geo:" + mRestaurant.getLatitude()
        + "," + mRestaurant.getLongitude()
        + "?q=(" + mRestaurant.getName() + ")"));
        startActivity(mapIntent);
        }
        }
