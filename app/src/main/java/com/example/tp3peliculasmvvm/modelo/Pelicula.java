package com.example.tp3peliculasmvvm.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo, descripcion, urlPortada, director, actores;

    public Pelicula(String titulo, String descripcion, String urlPortada, String director, String actores) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlPortada = urlPortada;
        this.director = director;
        this.actores = actores;
    }

    public Pelicula() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }
}
