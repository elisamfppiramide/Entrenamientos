package com.entrenamientos.demo.Ejercicios.domain;

public class Dureza {

    private int resistencia;
    private int velocidad;
    private int recuperacion;

    public Dureza(int resistencia, int velocidad, int recuperacion) {
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.recuperacion = recuperacion;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(int recuperacion) {
        this.recuperacion = recuperacion;
    }
}
