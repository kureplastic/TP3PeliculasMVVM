package com.example.tp3peliculasmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.tp3peliculasmvvm.databinding.ActivityMainBinding;
import com.example.tp3peliculasmvvm.modelo.Pelicula;

import java.util.ArrayList;

public class ListaPeliculasActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListaPeliculasActivityViewModel vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ListaPeliculasActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //armar grilla
        GridLayoutManager grilla = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        binding.rvLista.setLayoutManager(grilla);

        //observer del mutablePeliculas
        vm.getMutablePeliculas().observe(this, new Observer<ArrayList<Pelicula>>() {
            @Override
            public void onChanged(ArrayList<Pelicula> peliculas) {
                // aqui usar las peliculas para el adapter
                ListaPeliculasAdapter adapter = new ListaPeliculasAdapter(ListaPeliculasActivity.this,peliculas,getLayoutInflater());
                binding.rvLista.setAdapter(adapter);
            }
        });
    }
}