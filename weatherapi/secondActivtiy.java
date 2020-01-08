package com.darayuth.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.darayuth.weatherapi.contract.WeatherContract;

public class secondActivtiy extends AppCompatActivity {

    private EditText latitudeBtn;
    private EditText lontitudeBtn;

    private static final String TAG = "secondActivtiy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activtiy);
        init();
        display();
    }
    public void init(){
        latitudeBtn = (EditText) findViewById(R.id.latitudeEditText);
        lontitudeBtn = (EditText) findViewById(R.id.longtitudeEditText);
    }

    public void display(){
        Intent intent = getIntent();
        String latitudeReceived = intent.getStringExtra("longitude");
        String longTitudeRecieved = intent.getStringExtra("latitude");

        latitudeBtn.setText(latitudeReceived);
        lontitudeBtn.setText(longTitudeRecieved);
    }

}
