package com.entrenamientos.demo.Ejercicios.domain;

import java.util.List;

public class Materiales {

    private List<String> materiales;

    public Materiales(List<String> materiales) {
        this.materiales = materiales;
    }

    public List<String> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<String> materiales) {
        this.materiales = materiales;
    }
}
