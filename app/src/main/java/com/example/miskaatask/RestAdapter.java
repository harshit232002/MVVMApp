package com.example.miskaatask;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miskaatask.JavaApiResponse.JavaApiResponse;
import com.example.miskaatask.JavaApiResponse.Language;
import com.example.miskaatask.Repository.CountryRepository;
import com.example.miskaatask.Room.Country;
import com.example.miskaatask.databinding.ListItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.holder> {
    Context context;
    private static final String TAG = "RestAdapter";
    ListItemBinding binding;
    private List<Country> javaApiResponses = new ArrayList<>();


    public RestAdapter(Context context, List<Country> javaApiResponses) {
        this.context = context;
        this.javaApiResponses = javaApiResponses;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new holder(ListItemBinding.inflate(inflater));
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
//        String Name = "Name: "+javaApiResponses.get(position).getName();
//        holder.binding.name.setText(Name);
//        Log.d(TAG, "onBindViewHolder:name : "+javaApiResponses.get(position).getName());
//        String Capital = "Capital: " +javaApiResponses.get(position).getCapital();
//        holder.binding.capital.setText(Capital);
//        String flag_url = javaApiResponses.get(position).getFlag();
//        Glide.with(context).load(flag_url).into(holder.binding.flagImage);
//        String Region = "Region: " +javaApiResponses.get(position).getRegion();
//        holder.binding.region.setText(Region);
//        String Sub_Region = "Sub-Region: " +javaApiResponses.get(position).getSubregion();
//        holder.binding.subregion.setText(Sub_Region);
//        String Population = "Population: " +javaApiResponses.get(position).getPopulation();
//        holder.binding.population.setText(Population);
//        StringBuilder builder = new StringBuilder();
//        for (String border : javaApiResponses.get(position).getBorders()) {
//            builder.append(border + ", ");
//        }
//        holder.binding.borders.setText("Borders: " +builder.toString());
//        StringBuilder languages = new StringBuilder();
//        for (Language lan : javaApiResponses.get(position).getLanguages()) {
//            languages.append(lan.getName() + ", ");
//        }
//        holder.binding.languages.setText("Languages : " +languages.toString());
        holder.binding.name.setText("Name: " + javaApiResponses.get(position).getName());
        holder.binding.capital.setText("Capital: " + javaApiResponses.get(position).getCapital());
//        Picasso.get().load(javaApiResponses.get(position).getFlag()).error(R.color.black).into(holder.binding.flagImage);
        Util.fetchSvg(context,javaApiResponses.get(position).getFlag(),holder.binding.flagImage);
        holder.binding.region.setText("Region: " + javaApiResponses.get(position).getRegion());
        holder.binding.subregion.setText("Sub-Region: " + javaApiResponses.get(position).getSubRegion());
        holder.binding.population.setText("Population: " + javaApiResponses.get(position).getPopulation());
        StringBuilder builder = new StringBuilder();
        for (String border : javaApiResponses.get(position).getBorders()) {
            builder.append(border).append(", ");
        }
        holder.binding.borders.setText("Borders: " + builder.toString());
        StringBuilder languages = new StringBuilder();
        for (Language lan : javaApiResponses.get(position).getLanguages()) {
            languages.append(lan.getName()).append(", ");
        }
        holder.binding.languages.setText("Languages: " + languages.toString());

    }

    @Override
    public int getItemCount() {
        return javaApiResponses.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ListItemBinding binding;
        public holder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
