package com.example.testapp.network;

import com.example.testapp.pojo.PokemonsRespones;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiServies {

    @GET("pokemon")
    Observable<PokemonsRespones> getPokemons();
}
