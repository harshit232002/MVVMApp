package com.example.miskaatask.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.miskaatask.JavaApiResponse.Language;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NonNls;

import java.util.List;

@Entity
public class Country {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @SerializedName("name")
    @Expose
    String Name;
    @ColumnInfo
    @SerializedName("capital")
    @Expose
    String Capital;
    @SerializedName("flag")
    @Expose
    @ColumnInfo
    String Flag;
    @SerializedName("region")
    @Expose
    @ColumnInfo
    String Region;
    @ColumnInfo
    @SerializedName("subregion")
    @Expose
    String SubRegion;
    @ColumnInfo
    @SerializedName("population")
    @Expose
    String Population;
    @ColumnInfo
    @SerializedName("borders")
    @Expose
    @TypeConverters(DataConverter.class)
    List<String> Borders;
    @ColumnInfo
    @TypeConverters(DataConverter.class)
    @SerializedName("languages")
    @Expose
    List<Language> Languages;

    public Country() {
    }

    public Country(@NonNull String name, String capital, String flag, String region, String subRegion, String population, List<String> borders, List<Language> languages) {
        this.Name = name;
        this.Capital = capital;
        this.Flag = flag;
        this.Region = region;
        this.SubRegion = subRegion;
        this.Population = population;
        this.Borders = borders;
        this.Languages = languages;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getSubRegion() {
        return SubRegion;
    }

    public void setSubRegion(String subRegion) {
        SubRegion = subRegion;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public List<String> getBorders() {
        return Borders;
    }

    public void setBorders(List<String> borders) {
        Borders = borders;
    }

    public List<Language> getLanguages() {
        return Languages;
    }

    public void setLanguages(List<Language> languages) {
        Languages = languages;
    }
}
