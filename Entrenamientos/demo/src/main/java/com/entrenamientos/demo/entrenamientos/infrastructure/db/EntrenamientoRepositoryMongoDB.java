package com.entrenamientos.demo.entrenamientos.infrastructure.db;

import com.entrenamientos.demo.Ejercicios.domain.Dureza;
import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.context.MongoDBConnection;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.mongodb.client.MongoCollection;
import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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
        Document doc = collection.find(eq("_id", new ObjectId(id))).first();

        if (doc == null) {
            return null;
        }

        Entrenamiento entrenamiento = new Entrenamiento();
        entrenamiento.setIdMongo(doc.getObjectId("_id").toHexString());
        entrenamiento.setFecha(doc.getString("fecha"));

        List<Document> ejerciciosDoc = (List<Document>) doc.get("ejercicios");
        List<Ejercicio> ejercicios = new ArrayList<>();

        int totalResistencia = 0;
        int totalVelocidad = 0;
        int totalRecuperacion = 0;

        for (Document ejercicioDoc : ejerciciosDoc) {

            Document durezaDoc = ejercicioDoc.get("dureza", Document.class);

            int resistencia = durezaDoc.getInteger("resistencia");
            int velocidad = durezaDoc.getInteger("velocidad");
            int recuperacion = durezaDoc.getInteger("recuperacion");

            totalResistencia += resistencia;
            totalVelocidad += velocidad;
            totalRecuperacion += recuperacion;

            Dureza dureza = new Dureza(resistencia, velocidad, recuperacion);

            Ejercicio ejercicio = new Ejercicio(
                    ejercicioDoc.getObjectId("_id").toHexString(),
                    ejercicioDoc.getString("titulo"),
                    ejercicioDoc.getString("descripcion"),
                    ejercicioDoc.getList("etiquetas", String.class),
                    ejercicioDoc.getInteger("duracion"),
                    dureza,
                    null,
                    null
            );

            ejercicios.add(ejercicio);
        }

        entrenamiento.setEjercicios(ejercicios);
        int total = ejercicios.size();

        Dureza durezaMedia = new Dureza(
                totalResistencia / total,
                totalVelocidad / total,
                totalRecuperacion / total
        );

        entrenamiento.setDurezaMedia(durezaMedia);

        List<Document> asistentesDoc = (List<Document>) doc.get("asistentes");
        if (asistentesDoc != null) {
            List<Jugador> asistentes = new ArrayList<>();

            //Como lo hago aquí??? Jugador es INT id y aqui es STRING
            for (Document jugadorDoc : asistentesDoc) {
                Jugador jugador = new Jugador(
                        jugadorDoc.getObjectId("_id"),
                        jugadorDoc.getString("nombre")
                );
                asistentes.add(jugador);
            }

            entrenamiento.setAsistentes(asistentes);
        }

        return entrenamiento;
    }


    @Override
    public Entrenamiento addEntrenamiento(String fecha, List<Ejercicio> listaEjercicios) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenamientos");
        List<Document> ejercicios = new ArrayList<>();
        for(Ejercicio e : listaEjercicios){
            Document dureza = new Document().append("resistencia", e.getDureza().getResistencia()).append("velocidad", e.getDureza().getVelocidad()).append("recuperacion", e.getDureza().getRecuperacion());
            Document ejercicio = new Document().append("titulo", e.getTitulo()).append("descripcion", e.getDescripcion()).append("etiquetas", e.getEtiquetas()).append("duracion", e.getDuracion()).append("dureza", dureza).append("materiales", e.getMateriales()).append("recursos", e.getMultimedia());
            ejercicios.add(ejercicio);
        }
        Document entrenamiento = new Document().append("fecha", fecha).append("ejercicios", ejercicios).append("asistentes", new ArrayList<>());
        collection.insertOne(entrenamiento);


        //EL IDDDDDDDDDD ns q hacer
        return entrenamiento.getObjectId("_id");

    }

    @Override
    public Entrenamiento addAsistentes(String id, List<Jugador> listaAsistentes) {

    }

    @Override
    public void deleteEntrenamiento(String id) {

    }

}
