package com.example.testapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testapp.R;
import com.example.testapp.pojo.PokemonModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    ArrayList<PokemonModel> pokemonModels ;
    Context context ;

    public MyAdapter(ArrayList<PokemonModel> pokemonModels, Context context) {
        this.pokemonModels = pokemonModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item , parent , false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvName.setText(pokemonModels.get(position).getName());
        Glide.with(context).load(pokemonModels.get(position).getUrl()).into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return pokemonModels.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvName ;
        ImageView ivPoster;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            ivPoster = itemView.findViewById(R.id.ivPoster);

        }
    }
}
