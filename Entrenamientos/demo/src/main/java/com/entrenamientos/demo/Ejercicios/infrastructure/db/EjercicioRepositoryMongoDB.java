package com.entrenamientos.demo.Ejercicios.infrastructure.db;

import com.entrenamientos.demo.Ejercicios.domain.Ejercicio;
import com.entrenamientos.demo.Ejercicios.domain.EjercicioRepository;
import com.entrenamientos.demo.Ejercicios.domain.Material;
import com.entrenamientos.demo.context.MongoDBConnection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepositoryMongoDB implements EjercicioRepository {
    @Override
    public List<Ejercicio> listaEjercicios() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        FindIterable<Document> iterable = MongoDBConnection.getDatabase().getCollection("ejercicios").find();
        for (Document document: iterable){
            Ejercicio ejercicio = new Ejercicio();
            ejercicio.setIdMongo(document.getObjectId("_id").toString());
            ejercicio.setTitulo(document.getString("titulo"));
            ejercicio.setDescripcion(document.getString("descripcion"));
            List<Document> materiales = document.getList("materiales", Document.class);
            ejercicio.setMateriales(materiales);
            ejercicios.add(ejercicio);
        }
        return ejercicios;
    }

    @Override
    public Ejercicio mostrarEjercicioID(String id) {
        return null;
    }

    @Override
    public Ejercicio addEjercicio(Ejercicio ejercicio) {
        Document document = new Document();
        document.append("titulo", ejercicio.getTitulo());
        document.append("descripcion", ejercicio.getDescripcion());
        MongoDBConnection.getDatabase().getCollection("ejercicios").insertOne(document);
        return null;
    }

    @Override
    public Ejercicio add(Ejercicio ejercicio, Material material) {
        Document document = new Document();
        document.append("nombre", material.getNombre());
        Document filter = new Document("titulo", ejercicio.getTitulo());
        Document update = new Document("$push",
                new Document("materiales", document));
        Document ejercicioEnBD = MongoDBConnection.getDatabase().getCollection("ejercicios").find(filter).first();
        // Si existe el ejercicio, hago el push
        if (ejercicioEnBD != null && !ejercicioEnBD.isEmpty()) {
            MongoDBConnection.getDatabase()
                    .getCollection("ejercicios")
                    .updateOne(filter, update);
        }
        Ejercicio ejercicioDevolver = new Ejercicio();
        ejercicioDevolver.setIdMongo(ejercicioEnBD.getObjectId("_id").toString());
        ejercicioDevolver.setTitulo(ejercicioEnBD.getString("titulo"));
        ejercicioDevolver.setDescripcion(ejercicioEnBD.getString("descripcion"));
        return ejercicioDevolver;
    }
}
