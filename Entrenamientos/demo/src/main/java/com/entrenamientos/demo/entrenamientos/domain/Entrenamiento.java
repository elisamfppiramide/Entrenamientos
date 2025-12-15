package com.entrenamientos.demo.entrenamientos.domain;

import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.jugadores.domain.Jugador;

import java.util.List;

public class Entrenamiento {

    private String idMongo;
    private String fecha;
    private List<Jugador> asistentes;
    private List<Ejercicio> ejercicios;

    public String getIdMongo() {
        return idMongo;
    }

    public void setIdMongo(String idMongo) {
        this.idMongo = idMongo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Jugador> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Jugador> asistentes) {
        this.asistentes = asistentes;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
