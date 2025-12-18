package com.entrenamientos.demo.Ejercicios.domain;

import java.util.List;

public interface EjercicioRepository {

    //Id y titulo
    public List<Ejercicio> listaEjercicios();

    //Devuelve todos los datos de un ejercicio mostrando todas sus propiedades recibiendo su id en la URL.
    public Ejercicio mostrarEjercicioID(String id);

    //Recibe en el body todas sus propiedades para añadir un ejercicio.
    public Ejercicio addEjercicio(Ejercicio ejercicio);


    public Ejercicio add(Ejercicio ejercicio, Material material);
}
