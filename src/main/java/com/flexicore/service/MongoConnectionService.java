package com.flexicore.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConnectionService {


    public static final String MONGO_DB = "MongoDB";
    public static final String dbName = "flexicoreNoSQL";


    @Bean
    public MongoClient produceMongoClient() {
        return MongoClients.create("mongodb://localhost");

    }

    @Bean
    @Qualifier(MONGO_DB)
    public String productMongoClientDbName() {
        return dbName;
    }


    public static String getDbName() {
        return dbName;
    }
}
