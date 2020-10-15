package com.example.testapp.network;

import com.google.gson.Gson;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private PokemonApiServies pokemonApiServies;


    public PokemonApiServies getPokemonApiServies() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl("https://pokeapi.co/api/v2/")
                .build()
                .create(PokemonApiServies.class);
    }


}
