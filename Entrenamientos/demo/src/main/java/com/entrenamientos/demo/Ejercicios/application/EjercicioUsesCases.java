package com.entrenamientos.demo.Ejercicios.application;

import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.Ejercicios.domain.EjercicioRepository;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.application.JugadorUsesCases;
import com.entrenamientos.demo.jugadores.domain.JugadorRepository;

import java.util.List;

public class EjercicioUsesCases {

    private EjercicioRepository ejercicioRepository;

    public EjercicioUsesCases(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<Ejercicio> listaEjercicios(){
        return ejercicioRepository.listaEjercicios();
    }

    public Ejercicio mostrarEjercicioID(String id){
        return ejercicioRepository.mostrarEjercicioID(id);
    }

    public Ejercicio addEjercicio(Ejercicio ejercicio){
        return ejercicioRepository.addEjercicio(ejercicio);
    }


}
