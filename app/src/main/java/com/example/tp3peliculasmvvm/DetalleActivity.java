package com.example.tp3peliculasmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tp3peliculasmvvm.databinding.ActivityDetalleBinding;
import com.example.tp3peliculasmvvm.modelo.Pelicula;

public class DetalleActivity extends AppCompatActivity {

    private Context context;
    private ActivityDetalleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        context = getApplicationContext();
        setContentView(binding.getRoot());

        Bundle recuperarBundle = getIntent().getBundleExtra("pelicula");
        Pelicula pelicula = (Pelicula) recuperarBundle.getSerializable("pelicula");
        binding.tvDetalleTitulo.setText(pelicula.getTitulo());
        binding.tvDetalleActores.setText(pelicula.getActores());
        binding.tvDetalleDirector.setText(pelicula.getDirector());
        binding.tvDetalleDescripcion.setText(pelicula.getDescripcion());
        Glide.with(context)
                .load(pelicula.getUrlPortada())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivDetallePortada);
    }
}