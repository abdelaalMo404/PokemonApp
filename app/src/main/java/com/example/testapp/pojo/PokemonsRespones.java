package com.example.testapp.pojo;

import java.util.ArrayList;

public class PokemonsRespones {
    private int count;
    private String  next;
    private int  previous;
    private ArrayList<PokemonModel> results;


    public PokemonsRespones(int count, String next, int previous, ArrayList<PokemonModel> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public ArrayList<PokemonModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<PokemonModel> results) {
        this.results = results;
    }
}
