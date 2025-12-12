package com.entrenamientos.demo.entrenamientos.domain;

import com.entrenamientos.demo.jugadores.domain.Jugador;

import java.util.List;

public interface EntrenamientoRepository {

    public List<Entrenamiento> listaEntrenamientos();
    public Entrenamiento datosEntrenamientoYmedia(String id);
    public Entrenamiento addEntrenamiento(String fecha, List<Ejercicio> listaEjercicios);
    public Entrenamiento addAsistentes(String id, List<Jugador> listaAsistentes);
    public void deleteEntrenamiento(String id);

}
