package com.example.weathers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
        private TextView zone;
        private Context context=this;
        private Retrofit retrofit;
        private TextView homeTV;
        private String app_id = "b6907d289e10d714a6e88b30761fae22";
        private String lat = "35";
        private String lon = "139";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        zone=(TextView) findViewById(R.id.zone);
        homeTV=(TextView) findViewById(R.id.homeTempTV);

        retrofit= new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api =retrofit.create(ApiInterface.class);

        Call<WeatherPojo> call;
        call=api.getWeather(lat,lon,app_id);
        call.enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                WeatherPojo weather=response.body();
                //homeTV.setTextSize(60);
                homeTV.getTextSize();
                homeTV.setText(weather.getMain().getTemp().toString()+"\u00B0");
                System.out.println(weather.getTimezone().toString());
                Log.d("Weather", "Result "+weather.getMain().getTemp());
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {


                Log.d("Weather", "Not Found "+t);
            }
        });



        zone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}
