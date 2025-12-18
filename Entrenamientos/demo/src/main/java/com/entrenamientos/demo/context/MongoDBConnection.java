package com.entrenamientos.demo.context;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoDBConnection mongoDBConnection;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private MongoDBConnection(){
        this.mongoClient = MongoClients.create("mongodb+srv://dwes:nomevoyaolvidar123@prueba1.xupogib.mongodb.net/?appName=prueba1");
        this.database = mongoClient.getDatabase("deporte");
    }

    public static MongoDatabase getDatabase() {
        if(mongoDBConnection == null){
            mongoDBConnection = new MongoDBConnection();
        }
        return mongoDBConnection.database;
    }
}
