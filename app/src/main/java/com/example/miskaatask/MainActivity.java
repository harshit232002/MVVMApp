package com.example.miskaatask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.miskaatask.JavaApiResponse.JavaApiResponse;
import com.example.miskaatask.Retrofit.RetrofitClient;
import com.example.miskaatask.Room.Country;
import com.example.miskaatask.ViewModel.CoutryViewModel;
import com.example.miskaatask.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    RestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        CoutryViewModel viewModel = new CoutryViewModel(getApplication());
        CoutryViewModel viewModel = ViewModelProviders.of(this).get(CoutryViewModel.class);
//        viewModel.getVolumesResponseLiveData().observe(this, new Observer<List<JavaApiResponse>>() {
//            @Override
//            public void onChanged(List<JavaApiResponse> javaApiResponses) {
//                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
//                adapter = new RestAdapter(getApplicationContext(), javaApiResponses);
//                binding.recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//            }
//
//        });
        viewModel.getDatabase().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                adapter = new RestAdapter(getApplicationContext(), countries);
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }
}