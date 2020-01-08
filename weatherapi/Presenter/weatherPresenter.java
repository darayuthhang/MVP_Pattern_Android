package com.darayuth.weatherapi.Presenter;

import android.util.Log;

import com.darayuth.weatherapi.contract.WeatherContract;
import com.darayuth.weatherapi.model.Weather;
import com.darayuth.weatherapi.service.RequestApi;

public class weatherPresenter implements WeatherContract.Presenter {
    private static final String TAG = "weatherPresenter";
    private WeatherContract.View view;
    private Weather weather;


    public weatherPresenter(WeatherContract.View view){
        this.view = view;
        weather = new Weather();
    };

    @Override
    public void loadApi() {
        RequestApi api = new RequestApi(view);
        api.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");

    }


}
