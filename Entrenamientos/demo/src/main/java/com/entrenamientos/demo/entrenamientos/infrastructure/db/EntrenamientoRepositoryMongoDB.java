package com.entrenamientos.demo.entrenamientos.infrastructure.db;

import com.entrenamientos.demo.Ejercicios.domain.Dureza;
import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.context.MongoDBConnection;
import com.entrenamientos.demo.entrenamientos.domain.Entrenamiento;
import com.entrenamientos.demo.entrenamientos.domain.EntrenamientoRepository;
import com.entrenamientos.demo.jugadores.domain.Jugador;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
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

            for (Document jugadorDoc : asistentesDoc) {
                Jugador jugador = new Jugador(
                        jugadorDoc.getInteger("id"),
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
        int numEjercicios = 0;
        int resistencia = 0, velocidad = 0, recuperacion = 0;
        for(Ejercicio e : listaEjercicios){
            resistencia += e.getDureza().getResistencia();
            velocidad += e.getDureza().getVelocidad();
            recuperacion += e.getDureza().getRecuperacion();
            Document dureza = new Document().append("resistencia", e.getDureza().getResistencia()).append("velocidad", e.getDureza().getVelocidad()).append("recuperacion", e.getDureza().getRecuperacion());
            Document ejercicio = new Document().append("titulo", e.getTitulo()).append("descripcion", e.getDescripcion()).append("etiquetas", e.getEtiquetas()).append("duracion", e.getDuracion()).append("dureza", dureza).append("materiales", e.getMateriales()).append("recursos", e.getMultimedia());
            ejercicios.add(ejercicio);
        }
        resistencia = resistencia / numEjercicios;
        velocidad = velocidad / numEjercicios;
        recuperacion = recuperacion / numEjercicios;
        Document document = new Document().append("fecha", fecha).append("ejercicios", ejercicios).append("asistentes", new ArrayList<>());
        InsertOneResult result = collection.insertOne(document);
        String idMongo = result.getInsertedId().asString().toString();
        Entrenamiento entrenamiento = new Entrenamiento(idMongo, fecha,null, listaEjercicios, new Dureza(resistencia, velocidad, recuperacion));

        return entrenamiento;

    }

    @Override
    public Entrenamiento addAsistentes(String id, List<Jugador> listaAsistentes) {
        /*
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenamientos");
        Document doc = collection.find(eq("_id", new ObjectId(id))).first();
        Jugador jugador = new Jugador();
        Document asistente = new Document();
        asistente.append("dni", jugador.getDni()).append("apellidos", jugador.getApellidos()).append("fechaNacimiento", jugador.getFechaNacimiento()).append("velocidad", jugador.getVelocidad()).append("resistencia", jugador.getResistencia()).append("recuperacion", jugador.getRecuperacion());
        Document filter = new Document("dni", jugador.getDni());
        Document update = new Document("$push",
                new Document("", ));

*/
        return null;


    }

    @Override
    public void deleteEntrenamiento(String id) {

    }

}
