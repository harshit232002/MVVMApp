package com.example.miskaatask.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miskaatask.JavaApiResponse.JavaApiResponse;
import com.example.miskaatask.Retrofit.RetrofitClient;
import com.example.miskaatask.Room.Country;
import com.example.miskaatask.Room.CountryDAO;
import com.example.miskaatask.Room.CountryDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CountryRepository {
    private static final String TAG = "CountryRepository";
    private LiveData<List<Country>> ApiResponse;
    private MutableLiveData<List<Country>> listLiveData;
    CountryDAO countryDAO;

    public CountryRepository(Application application) {
        CountryDatabase databaseClient = CountryDatabase.getInstance(application);
        countryDAO = databaseClient.CountryDao();
        ApiResponse = countryDAO.getAllCountry();
    }

    public void insert(List<Country> country)
    {
     new InsertCountryAsyncTask(countryDAO).execute(country);
    }

    public LiveData<List<Country>> getAllCountry(){
        return ApiResponse;
    }

    //get data
    public LiveData<List<Country>> getResponse() {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<List<Country>>();

            loadHeroes();
        }
        //if not null return this list
        return listLiveData;
    }

    private void loadHeroes() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
       retrofitClient.getdataServices().getData().enqueue(new Callback<List<Country>>() {
           @Override
           public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
               Log.d(TAG, "onResponse: "+response);
               if (response.isSuccessful())
               {
                   insert(response.body());
               }
           }

           @Override
           public void onFailure(Call<List<Country>> call, Throwable t) {
               Log.d(TAG, "onFailure: t: "+t.getMessage());
           }
       });

    }

    private static class InsertCountryAsyncTask extends AsyncTask<List<Country>, Void, Void>{
        private CountryDAO countryDAO;

        public InsertCountryAsyncTask(CountryDAO countryDAO) {
            this.countryDAO = countryDAO;
        }

        @Override
        protected Void doInBackground(List<Country>... countries) {
            countryDAO.Insert(countries[0]);
            return null;
        }
    }
}
