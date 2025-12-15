package com.entrenamientos.demo.entrenamientos.application;

import com.entrenamientos.demo.Ejercicios.domain.EjercicioRepository;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
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

    private
}
