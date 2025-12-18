package com.entrenamientos.demo.Ejercicios.infrastructure.rest;

import com.entrenamientos.demo.Ejercicios.application.EjercicioUsesCases;
import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.Ejercicios.domain.Material;
import com.entrenamientos.demo.Ejercicios.infrastructure.db.EjercicioRepositoryMongoDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EjerciciosRestController {

    private EjercicioUsesCases ejercicioUsesCases;

    public EjerciciosRestController(){
        this.ejercicioUsesCases = new EjercicioUsesCases(new EjercicioRepositoryMongoDB());
    }

    @GetMapping("/api/ejercicios")
    public List<Ejercicio> get(){
        return this.ejercicioUsesCases.listaEjercicios();
    }

    @PostMapping("/api/ejercicios")
    public Ejercicio save(@RequestBody Ejercicio ejercicio){
        this.ejercicioUsesCases.addEjercicio(ejercicio);
        return ejercicio;
    }

    @PutMapping("/api/ejercicios/{titulo}")
    public Ejercicio ponMaterial(@RequestBody Material material, @PathVariable String titulo){
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setTitulo(titulo);
        return this.ejercicioUsesCases.add(ejercicio, material);
    }

}
