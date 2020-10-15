package com.example.testapp.repo;

import com.example.testapp.network.PokemonApiServies;
import com.example.testapp.network.RetrofitInstance;
import com.example.testapp.pojo.PokemonsRespones;

import io.reactivex.rxjava3.core.Observable;

public class Repo {
    RetrofitInstance instance;
    public static PokemonApiServies pokemonApiServies ;




    public Observable<PokemonsRespones> getPokemons (){
        instance = new RetrofitInstance();
        pokemonApiServies = instance.getPokemonApiServies();
        return pokemonApiServies.getPokemons();
    }
}
