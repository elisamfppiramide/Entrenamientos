package com.entrenamientos.demo.jugadores.infrastructure.db;

import com.entrenamientos.demo.context.MySQLDBConnection;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.entrenamientos.demo.jugadores.domain.JugadorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepositoryMySQL implements JugadorRepository {
    @Override
    public void reset() {
        String query = "delete from jugador";
        try{
            PreparedStatement ps = MySQLDBConnection.getInstance().prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Jugador jugador) {
        String query = "insert into jugador (dni, nombre, apellidos, fechaNacimiento, resistencia, velocidad, recuperacion) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = MySQLDBConnection.getInstance().prepareStatement(query);
            ps.setString(1, jugador.getDni());
            ps.setString(2, jugador.getNombre());
            ps.setString(3, jugador.getApellidos());
            ps.setString(4, jugador.getFechaNacimiento());
            ps.setInt(5, jugador.getResistencia());
            ps.setInt(6, jugador.getVelocidad());
            ps.setInt(7, jugador.getRecuperacion());
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<Jugador> jugadores() {
        String query = "select dni, nombre, apellidos from jugador";
        List<Jugador> jugadores = new ArrayList<>();
        try {
            PreparedStatement ps = MySQLDBConnection.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                jugadores.add(new Jugador(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos")));
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }
        return jugadores;
    }

    @Override
    public Jugador jugadorId(int id) {
        String query = "select * from jugador where id = ?";
        Jugador jugador = null;
        try{
            PreparedStatement ps = MySQLDBConnection.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jugador = new Jugador(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("fechaNacimiento"),
                        rs.getInt("resistencia"),
                        rs.getInt("velocidad"),
                        rs.getInt("recuperacion")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugador;
    }

    @Override
    public Jugador actualizar(int id, Jugador jugadorNuevo) {
        String query = "UPDATE jugador SET dni = ?, nombre = ?, apellidos = ?, fechaNacimiento = ?, resistencia = ?, velocidad = ?, recuperacion = ? where id = ?";
        try{
            PreparedStatement ps = MySQLDBConnection.getInstance().prepareStatement(query);
            ps.setString(1, jugadorNuevo.getDni());
            ps.setString(2, jugadorNuevo.getNombre());
            ps.setString(3, jugadorNuevo.getApellidos());
            ps.setString(4, jugadorNuevo.getFechaNacimiento());
            ps.setInt(5, jugadorNuevo.getResistencia());
            ps.setInt(6, jugadorNuevo.getVelocidad());
            ps.setInt(7, jugadorNuevo.getRecuperacion());
            ps.setInt(8, id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return jugadorNuevo;
    }
}
