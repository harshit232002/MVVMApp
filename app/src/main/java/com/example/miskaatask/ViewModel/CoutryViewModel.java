package com.example.miskaatask.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.miskaatask.JavaApiResponse.JavaApiResponse;
import com.example.miskaatask.Repository.CountryRepository;
import com.example.miskaatask.Room.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoutryViewModel extends AndroidViewModel {
    private static final String TAG = "CoutryViewModel";
    private CountryRepository countryRepository;
    private  LiveData<List<Country>> listLiveData;



    public CoutryViewModel(Application application){
        super(application);
        countryRepository = new CountryRepository(application);
        listLiveData = countryRepository.getAllCountry();

    }

    public LiveData<List<Country>> getDatabase(){
        return listLiveData;
    }

//    public LiveData<List<Country>> getVolumesResponseLiveData() {
//        return listLiveData;
//    }

}
