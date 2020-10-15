package com.example.testapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.testapp.pojo.PokemonModel;
import com.example.testapp.pojo.PokemonsRespones;
import com.example.testapp.repo.Repo;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private MutableLiveData<ArrayList<PokemonModel>> pokemonLive = new MutableLiveData<>();
    Repo repo = new Repo();


    public MutableLiveData<ArrayList<PokemonModel>> getPokemonLive() {
        return pokemonLive;
    }

    public void getPokemon(){
        repo.getPokemons()
                .subscribeOn(Schedulers.io())
                .map(new Function<PokemonsRespones, ArrayList<PokemonModel>>() {
                    @Override
                    public ArrayList<PokemonModel> apply(PokemonsRespones pokemonsRespones) throws Throwable {
                        ArrayList<PokemonModel> list = pokemonsRespones.getResults();
                        for (PokemonModel pokemonModel : list){
                            String url = pokemonModel.getUrl();
                            String [] pokeIndex = url.split("/");
                            pokemonModel.setUrl("https://pokeres.bastionbot.org/images/pokemon/"+pokeIndex[pokeIndex.length-1] + ".png");

                        }

                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res->pokemonLive.setValue(res)
                ,error-> Log.d(TAG, "getPokemon: " + error.getMessage()));
    }

}
