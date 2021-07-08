package com.example.miskaatask.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.miskaatask.Room.Country;

import java.util.List;

@Dao
public interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void Insert(List<Country> country);


    @Query("SELECT * FROM Country")
    public LiveData<List<Country>> getAllCountry();

}
