package com.entrenamientos.demo.Ejercicios.application;

import com.entrenamientos.demo.Ejercicios.domain.EjercicioRepository;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.application.JugadorUsesCases;
import com.entrenamientos.demo.jugadores.domain.JugadorRepository;

public class EjercicioUsesCases {

    private EjercicioRepository ejercicioRepository;
    private EntrenamientoRepository entrenamientoRepository;
    private JugadorRepository jugadorRepository;

    public EjercicioUsesCases(EjercicioRepository ejercicioRepository, EntrenamientoRepository entrenamientoRepository, JugadorRepository jugadorRepository) {
        this.ejercicioRepository = ejercicioRepository;
        this.entrenamientoRepository = entrenamientoRepository;
        this.jugadorRepository = jugadorRepository;
    }


}
