package com.dicksonmully6gmail.weatherapp.models;

/**
 * Created by dickson on 5/30/17.
 */



        import org.parceler.Parcel;

        import java.util.ArrayList;

/**
 * Created by dickson on 5/27/17.
 */

@Parcel
public class Weather {
    // fields must be public
    double mTime;
    double mWindSpeed;
    double mHumidity;
    double mTemp;
    String mMainType;
    String mDescription;
    String mIcon;

    //    empty constructor needed by the Parceler library
    public Weather() {}

    public Weather(double time, double temp, double humidity,
                      double windSpeed, String mainType, String description, String icon) {
        this.mTime = time;
        this.mWindSpeed = windSpeed;
        this.mHumidity = humidity;
        this.mTemp = temp;
        this.mMainType = mainType;
        this.mDescription = description;
        this.mIcon = icon;
    }

    public double getTime() {
        return mTime;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public double getHumidity() {
        return  mHumidity;
    }

    public double getTemp() {
        return mTemp;
    }

    public String getMainType(){
        return mMainType;
    }
    public String getIcon(){
        return mIcon;
    }
    public String getDescription(){
        return mDescription;
    }
}
}