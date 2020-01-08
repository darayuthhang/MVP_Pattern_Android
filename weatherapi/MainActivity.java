package com.darayuth.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.darayuth.weatherapi.Presenter.weatherPresenter;
import com.darayuth.weatherapi.contract.WeatherContract;

public class MainActivity extends AppCompatActivity implements WeatherContract.View, View.OnClickListener {
    private WeatherContract.Presenter mPresenter;
    private Button button;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new weatherPresenter(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void showMessage() {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.d(TAG, "onClick: click begin");
                mPresenter.loadApi();
                break;
        }
    }

    @Override
    public void switchtActivity(String lontitude, String latitude) {
        Intent intent = new Intent(this, secondActivtiy.class);

        intent.putExtra("longitude", lontitude);
        intent.putExtra("latitude", latitude);
        startActivity(intent);
    }

    //    public void switchtActivity(String latitude, String lontitude) {
//        Intent intent = new Intent(this, secondActivtiy.class);
//        startActivity(intent);
//    }
}
