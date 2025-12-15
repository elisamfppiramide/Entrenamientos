package com.entrenamientos.demo.entrenamientos.infrastructure.db;

import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.context.MongoDBConnection;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EntrenamientoRepositoryMongoDB implements EntrenamientoRepository {

    public List<Entrenamiento> listaEntrenamientos(){
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenamientos");
        for(Document document: collection.find()){
            System.out.println(document.toJson());
        }
        return List.of();
    }

    @Override
    public Entrenamiento datosEntrenamientoYmedia(String id) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenamientos");
        Document document = collection.find(new Document("id", id)).first();
        if(document == null){
            return null;
        }
        Entrenamiento entrenamiento = new Entrenamiento();
        entrenamiento.setIdMongo(document.getString("id"));
        entrenamiento.setFecha(document.getString("fecha"));
        List<Document> ejercicios = (List<Document>)document.get("ejercicios");
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        int totalResistencia = 0;
        int totalVelocidad = 0;
        int totalRecuperacion = 0;

        for(Document ejercicio: ejercicios){
            Document dureza = (Document) ejercicio.get("dureza");
            Ejercicio ejercicio1 = new Ejercicio()
        }

    }

    @Override
    public Entrenamiento addEntrenamiento(String fecha, List<Ejercicio> listaEjercicios) {
        return null;
    }

    @Override
    public Entrenamiento addAsistentes(String id, List<Jugador> listaAsistentes) {
        return null;
    }

    @Override
    public void deleteEntrenamiento(String id) {

    }

}
