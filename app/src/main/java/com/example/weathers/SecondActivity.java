package com.example.weathers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {
    List<ImagePojo> images;
     RecyclerView recycler;
    Context context;
    private ImageAdapter imgadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          final String app_id = "2e65127e909e178d0af311a81f39948c";
          final String lat = "35";
          final String lon = "139";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        images=new ArrayList<>();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        recycler=(RecyclerView) findViewById(R.id.recycle);
        imgadapter=new ImageAdapter(images,context);
        recycler.setAdapter(imgadapter);
        //Retrofit Object creating
        Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api=retrofit.create(ApiInterface.class);
        Call<WeatherPojo> call;

        call=api.getWeather(lat,lon,app_id);
        call.enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                WeatherPojo weather = response.body();

                Log.d("Weather","Result "+weather.getMain().);
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {
                Log.d("Weather", "NO "+t);
            }
        });


        ImagePojo img=new ImagePojo(R.drawable.ic_beach_sunset);
        images.add(img);
        ImagePojo imgs=new ImagePojo(R.drawable.ic_ph_sunset);
        images.add(imgs);
        ImagePojo imgse=new ImagePojo(R.drawable.ic_sunrise);
        images.add(imgse);
        ImagePojo imgss=new ImagePojo(R.drawable.ic_sunset);
        images.add(imgss);
        ImagePojo imgser=new ImagePojo(R.drawable.ic_sunrise);
        images.add(imgser);
        ImagePojo imgt=new ImagePojo(R.drawable.ic_sunrise_pink);
        images.add(imgt);
    }
}
