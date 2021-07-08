package com.example.miskaatask.Room;


import androidx.room.TypeConverter;

import com.example.miskaatask.JavaApiResponse.Currency;
import com.example.miskaatask.JavaApiResponse.Language;
import com.example.miskaatask.JavaApiResponse.RegionalBloc;
import com.example.miskaatask.JavaApiResponse.Translations;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class DataConverter implements Serializable {

    @TypeConverter // note this annotation
    public String fromOptionValuesList(List<String> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<String> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(optionValuesString, type);
        return list;
    }

//    @TypeConverter // note this annotation
//    public Double fromDouble(List<Double> optionValues) {
//        if (optionValues == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Double>>() {
//        }.getType();
//        Double json = Double.valueOf(gson.toJson(optionValues, type));
//        return json;
//    }
//
//    @TypeConverter // note this annotation
//    public List<Double> toDouble(Double optionValuesString) {
//        if (optionValuesString == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Double>>() {
//        }.getType();
//        List<Double> list = gson.fromJson(String.valueOf(optionValuesString), type);
//        return list;
//    }

    @TypeConverter // note this annotation
    public String fromLanguage(List<Language> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Language>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Language> toLanguage(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Language>>() {
        }.getType();
        List<Language> list = gson.fromJson(optionValuesString, type);
        return list;
    }

//    @TypeConverter // note this annotation
//    public String fromCurrency(List<Currency> optionValues) {
//        if (optionValues == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Currency>>() {
//        }.getType();
//        String json = gson.toJson(optionValues, type);
//        return json;
//    }
//
//    @TypeConverter // note this annotation
//    public List<Currency> toCurrency(String optionValuesString) {
//        if (optionValuesString == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<Currency>>() {
//        }.getType();
//        List<Currency> list = gson.fromJson(optionValuesString, type);
//        return list;
//    }
//
//    @TypeConverter // note this annotation
//    public String fromR(List<RegionalBloc> optionValues) {
//        if (optionValues == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<RegionalBloc>>() {
//        }.getType();
//        String json = gson.toJson(optionValues, type);
//        return json;
//    }
//
//    @TypeConverter // note this annotation
//    public List<RegionalBloc> toR(String optionValuesString) {
//        if (optionValuesString == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<List<RegionalBloc>>() {
//        }.getType();
//        List<RegionalBloc> list = gson.fromJson(optionValuesString, type);
//        return list;
//    }
//
//    @TypeConverter // note this annotation
//    public String fromt(Translations optionValues) {
//        if (optionValues == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<Translations>() {
//        }.getType();
//        String json = gson.toJson(optionValues, type);
//        return json;
//    }
//
//    @TypeConverter // note this annotation
//    public Translations tot(String optionValuesString) {
//        if (optionValuesString == null) {
//            return (null);
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<Translations>() {
//        }.getType();
//        Translations list = gson.fromJson(optionValuesString, type);
//        return list;
//    }

}