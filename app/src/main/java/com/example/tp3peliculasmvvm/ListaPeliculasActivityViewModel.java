package com.example.tp3peliculasmvvm;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp3peliculasmvvm.modelo.Pelicula;

import java.util.ArrayList;

public class ListaPeliculasActivityViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Pelicula>> mutablePeliculas;
    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    private Context context;

    public ListaPeliculasActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<ArrayList<Pelicula>> getMutablePeliculas(){
        if(mutablePeliculas == null){
            mutablePeliculas = new MutableLiveData<>();
            //llenar mutable con peliculas luego de haber inicializado
            llenarMutable();
        }
        return mutablePeliculas;
    }
    private void llenarMutable(){
        // agregar peliculas
        peliculas.add(new Pelicula("Indiana Jones",
                "En 1938, después de la desaparición de su padre el profesor Henry Jones en su búsqueda del Santo Grial, Indiana Jones se enfrenta de nuevo a los Nazis para que evitar que obtengan sus poderes.",
                "https://m.media-amazon.com/images/M/MV5BZTM3ZTJhNTYtNWUwYS00NmE1LTkxMTMtZTdjNTk1MjljZDIyXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_.jpg",
                "Steven SPielberg","Harrison Ford, Otros"));
        peliculas.add(new Pelicula("Glass",
                "El guarda de seguridad, David Dunn utiliza sus habilidades supernaturales para encontrar a Kevin Wendell Crumb, un hombre trastornado por veinticuatro personalidades.",
                "https://m.media-amazon.com/images/M/MV5BMTY1OTA2MjI5OV5BMl5BanBnXkFtZTgwNzkxMjU4NjM@._V1_FMjpg_UX770_.jpg",
                "M Night Shaymalan","Bruce Willis, James McAvoy, Samuel L Jackson"));
        peliculas.add(new Pelicula("La Llegada",
                "Después de que doce naves espaciales misteriosas aparecen en todo el mundo, Un lingüista deberá trabajar con los militares para poder comunicarse con las formas de vida extraterrestres.",
                "https://m.media-amazon.com/images/M/MV5BNTY1YjM0NzEtMzY0Yy00ZGNmLWI3YmYtNjE5NWUwNWMyOWFhXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_FMjpg_UX566_.jpg",
                "Denis Villenueve","Amy Adams, Jeremy Renner"));

        //agregar peliculas al mutable
        mutablePeliculas.setValue(peliculas);
    }




}
