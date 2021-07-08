package com.example.miskaatask.Retrofit;

import com.example.miskaatask.JavaApiResponse.JavaApiResponse;
import com.example.miskaatask.Room.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getDataServices {

    @GET("region/asia")
    Call<List<Country>> getData();
}
