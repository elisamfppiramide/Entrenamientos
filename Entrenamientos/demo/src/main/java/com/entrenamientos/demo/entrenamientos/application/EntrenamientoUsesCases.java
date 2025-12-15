package com.entrenamientos.demo.entrenamientos.application;

import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.Ejercicios.domain.EjercicioRepository;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.entrenamientos.demo.jugadores.domain.JugadorRepository;

import java.util.List;

public class EntrenamientoUsesCases {

    private EntrenamientoRepository entrenamientoRepository;
    private JugadorRepository jugadorRepository;
    private EjercicioRepository ejercicioRepository;

    public EntrenamientoUsesCases(EntrenamientoRepository entrenamientoRepository, JugadorRepository jugadorRepository, EjercicioRepository ejercicioRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
        this.jugadorRepository = jugadorRepository;
        this.ejercicioRepository = ejercicioRepository;
    }

    private List<Entrenamiento> listaEntrenamientos(){
        return this.entrenamientoRepository.listaEntrenamientos();
    }

    private Entrenamiento datosConMedia(String id){
        return this.entrenamientoRepository.datosEntrenamientoYmedia(id);
    }
    private Entrenamiento addEntrenamiento(String fecha, List<Ejercicio> ejercicios){
        return this.entrenamientoRepository.addEntrenamiento(fecha, ejercicioRepository.listaEjercicios());
    }

    public Entrenamiento addAsistentes(String id, List<Jugador> listaJugadores){
        return this.entrenamientoRepository.addAsistentes(id, jugadorRepository.jugadores());
    }

    public void deleteEntrenamiento(String id){
        this.entrenamientoRepository.deleteEntrenamiento(id);
    }


}
