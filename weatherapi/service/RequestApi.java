package com.darayuth.weatherapi.service;

import android.os.AsyncTask;
import android.util.Log;

import com.darayuth.weatherapi.contract.WeatherContract;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestApi extends AsyncTask<String, Void, String> {
    private static final String TAG = "Download";

    private WeatherContract.View view;

    public RequestApi(WeatherContract.View view){
        this.view = view;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.e(TAG, "onPostExecute: " );
        try{
            Log.e(TAG, "postExcute2: "  );
            JSONObject jsonObject = new JSONObject(s);
            JSONObject coordObject = jsonObject.getJSONObject("coord");
            String lontitude = coordObject.getString("lon");
            String latitude = coordObject.getString("lat");
            //pass paramter back to view to display data
            //to second activity
            this.view.switchtActivity(lontitude, latitude);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected String doInBackground(String... strings) {
        String result = init(strings[0]);
        return result;
    }

    public String init(String urlPath){
        StringBuilder responseContext = new StringBuilder();
        try{

            URL url = new URL(urlPath );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //get reponse code whether you can connect or not
            int reponse = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseContext.append(inputLine);
            }
            Log.d(TAG, "afterDownload "+ responseContext);
            in.close();
            return responseContext.toString();

        }catch (MalformedURLException e){
            Log.e(TAG, "init: "+ e.getMessage());
        }catch (IOException e){
            Log.e(TAG, "init: "+ e.getMessage());
        }catch (SecurityException e){
            Log.e(TAG, "init: "+ e.getMessage());
        }
        return null;
    }


}
