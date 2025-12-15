package com.entrenamientos.demo.context;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoDBConnection mongoDBConnection;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private MongoDBConnection(){
        this.mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017");
        this.database = mongoClient.getDatabase("animalitos-app");
    }

    public static MongoDatabase getDatabase() {
        if(mongoDBConnection == null){
            mongoDBConnection = new MongoDBConnection();
        }
        return mongoDBConnection.database;
    }
}
