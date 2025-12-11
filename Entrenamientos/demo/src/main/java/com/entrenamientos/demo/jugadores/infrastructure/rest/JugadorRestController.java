package com.entrenamientos.demo.jugadores.infrastructure.rest;

import com.entrenamientos.demo.jugadores.application.JugadorUsesCases;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.entrenamientos.demo.jugadores.infrastructure.db.JugadorRepositoryMySQL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorRestController {

    private JugadorUsesCases jugadorUsesCases;

    public JugadorRestController(){
        this.jugadorUsesCases = new JugadorUsesCases(new JugadorRepositoryMySQL());
    }

    @GetMapping("/")
    public List<Jugador> listaJugadores(){
        return this.jugadorUsesCases.jugadores();
    }

    @PostMapping("/")
    public void guardarJugador(@RequestBody Jugador jugador){
        this.jugadorUsesCases.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizarJugador(@PathVariable int id, @RequestBody Jugador jugador){
        return this.jugadorUsesCases.actualizar(id, jugador);
    }

    @GetMapping("/{id}")
    public Jugador jugadorPorId(@PathVariable int id){
        return this.jugadorUsesCases.jugadorId(id);
    }


}
