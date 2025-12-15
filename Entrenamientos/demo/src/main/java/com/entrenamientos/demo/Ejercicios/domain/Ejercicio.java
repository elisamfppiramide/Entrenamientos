package com.entrenamientos.demo.Ejercicios.domain;

import java.util.List;

public class Ejercicio {

    private String idMongo;
    private String titulo;
    private String descripcion;
    private List<String> etiquetas;
    private int duracion;
    private Dureza dureza;
    private List<Materiales> materiales;
    private List<Multimedia> multimedia;

    public Ejercicio(String idMongo, String titulo, String descripcion, List<String> etiquetas, int duracion, Dureza dureza, List<Materiales> materiales, List<Multimedia> multimedia) {
        this.idMongo = idMongo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.duracion = duracion;
        this.dureza = dureza;
        this.materiales = materiales;
        this.multimedia = multimedia;
    }

    public String getIdMongo() {
        return idMongo;
    }

    public void setIdMongo(String idMongo) {
        this.idMongo = idMongo;
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

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Dureza getDureza() {
        return dureza;
    }

    public void setDureza(Dureza dureza) {
        this.dureza = dureza;
    }

    public List<Materiales> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Materiales> materiales) {
        this.materiales = materiales;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }
}
