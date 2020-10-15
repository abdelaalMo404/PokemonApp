package com.example.testapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapp.R;
import com.example.testapp.adapters.MyAdapter;
import com.example.testapp.pojo.PokemonModel;
import com.example.testapp.viewmodel.ViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    MyAdapter adapter;
    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));




        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getPokemon();

        viewModel.getPokemonLive().observe(this, new Observer<ArrayList<PokemonModel>>() {
            @Override
            public void onChanged(ArrayList<PokemonModel> pokemonModels) {
                adapter = new MyAdapter(pokemonModels , getApplicationContext());
                rv.setAdapter(adapter);
            }
        });


    }
}