package com.darayuth.weatherapi.contract;

public interface WeatherContract {

    /***** view only display displaya data ****/
    public interface View{
        void showMessage();
        void showError();
        void switchtActivity(String lontitude, String latitude);
    }

    public interface Presenter{
        void loadApi();
    }

}
