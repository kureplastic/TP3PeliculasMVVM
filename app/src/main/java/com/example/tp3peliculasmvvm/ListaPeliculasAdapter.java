package com.example.tp3peliculasmvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tp3peliculasmvvm.modelo.Pelicula;

import java.util.ArrayList;

public class ListaPeliculasAdapter extends RecyclerView.Adapter<ListaPeliculasAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Pelicula> peliculas;

    public ListaPeliculasAdapter(Context context,ArrayList<Pelicula> peliculas, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public ListaPeliculasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= inflater.inflate(R.layout.item_pelicula,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPeliculasAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // por cada item(pelicula) que haga bind se hace esto
        holder.tvTitulo.setText(peliculas.get(position).getTitulo());
        holder.tvDescripcion.setText(peliculas.get(position).getDescripcion());
        Glide.with(context)
                .load(peliculas.get(position).getUrlPortada())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivPortada);
        holder.btDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pelicula",peliculas.get(position));
                Intent intent = new Intent(context, DetalleActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .putExtra("pelicula",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitulo, tvDescripcion;
        ImageView ivPortada;
        Button btDetalle;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            btDetalle = itemView.findViewById(R.id.btDetalle);
            tvTitulo =itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            ivPortada = itemView.findViewById(R.id.ivPortada);
        }
    }
}
