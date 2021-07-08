package com.example.miskaatask.Room;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.miskaatask.JavaApiResponse.JavaApiResponse;

import java.util.List;

@Database(entities = Country.class, version = 1)
@TypeConverters(DataConverter.class)
public abstract class CountryDatabase extends RoomDatabase {
    private static CountryDatabase mInstance;
    public abstract CountryDAO CountryDao();

    public static synchronized CountryDatabase getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(mCtx.getApplicationContext(),CountryDatabase.class,"CountryDatabase")
                    .addCallback(callback)
                    .build();
        }
        return mInstance;
    }

    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(mInstance);
        }
    };

    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void> {
        private CountryDAO countryDAO;
        private List<Country> country;
        public PopulateDbAsyn(CountryDatabase countryDatabase)
        {
            countryDAO=countryDatabase.CountryDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            countryDAO.Insert(country);
            return null;
        }
    }
}

