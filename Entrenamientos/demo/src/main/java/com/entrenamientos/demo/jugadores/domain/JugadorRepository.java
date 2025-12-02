package com.entrenamientos.demo.jugadores.domain;

import java.util.List;

public interface JugadorRepository {
    public void reset();
    public void save(Jugador jugador);
    public List<Jugador> jugadores();
    public Jugador jugadorId(int id);
    public Jugador actualizar(int id, Jugador jugadorNuevo);

}
