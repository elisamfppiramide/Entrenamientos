package com.entrenamientos.demo.jugadores.domain;

import java.util.Date;

public class Jugador {
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private int resistencia;
    private int velocidad;
    private int recuperacion;

    public Jugador(int id, String dni, String nombre, String apellidos, String fechaNacimiento, int resistencia, int velocidad, int recuperacion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.recuperacion = recuperacion;
    }

    public Jugador(String dni, String nombre, String apellidos){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Jugador(String dni){
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getRecuperacion() {
        return recuperacion;
    }
}
