package com.entrenamientos.demo.Ejercicios.domain;

import java.util.List;

public class Ejercicio {

    private String idMongo;
    private String titulo;
    private String descripcion;
    private List<String> etiquetas;
    private Integer duracion;
    private Dureza dureza;
    private List<Material> materialesString;
    private List<Multimedia> multimedia;

    public Ejercicio(){}

    public Ejercicio(String idMongo, String titulo, String descripcion, List<String> etiquetas, Integer duracion, Dureza dureza, List<Material> materialesString, List<Multimedia> multimedia) {
        this.idMongo = idMongo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.duracion = duracion;
        this.dureza = dureza;
        this.materialesString = materialesString;
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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Dureza getDureza() {
        return dureza;
    }

    public void setDureza(Dureza dureza) {
        this.dureza = dureza;
    }

    public List<Material> getMateriales() {
        return materialesString;
    }

    public void setMateriales(List<Material> materiales) {
        this.materialesString = materiales;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }
}
