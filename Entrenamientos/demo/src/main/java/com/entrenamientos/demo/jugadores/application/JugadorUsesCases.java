package com.entrenamientos.demo.jugadores.application;

import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.entrenamientos.demo.jugadores.domain.JugadorRepository;

import java.util.List;

public class JugadorUsesCases {

    private JugadorRepository jugadorRepository;

    public JugadorUsesCases(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
    }

    public void reset(){
        this.jugadorRepository.reset();
    }

    public void save(Jugador jugador){
        if(jugador.getResistencia() > 3 || jugador.getResistencia() <= 0){
            throw new IllegalArgumentException("Los valores deben ser 1, 2 o 3");
        } else if (jugador.getRecuperacion() > 3 || jugador.getRecuperacion() <=0) {
            throw new IllegalArgumentException("Los valores deben ser 1, 2 o 3");
        } else if (jugador.getVelocidad() > 3 || jugador.getVelocidad() <=0) {
            throw new IllegalArgumentException("Los valores deben ser 1, 2 o 3");
        }else{
            this.jugadorRepository.save(jugador);
        }

    }

    public List<Jugador> jugadores(){
      return this.jugadorRepository.jugadores();
    }

    public Jugador jugadorId(int id){
        return this.jugadorRepository.jugadorId(id);
    }

    public Jugador actualizar(int id, Jugador nuevo){
        this.jugadorRepository.actualizar(id, nuevo);
        return nuevo;
    }
}
