package com.example.weathers;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL="https://openweathermap.org/";


    @GET("data/2.5/weather?")
    Call<WeatherPojo> getWeather(@Query("lat") String lat, @Query("lon") String lon,@Query("APPID") String app_id);
}
