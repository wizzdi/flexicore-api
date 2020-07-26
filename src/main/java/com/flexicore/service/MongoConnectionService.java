package com.flexicore.service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConnectionService {


    public static final String MONGO_DB = "MongoDB";
    public static final String dbName = "flexicoreNoSQL";

    @Value("${spring.data.mongodb.uri:mongodb://localhost}")
    private String connectionString;


    @Bean
    public MongoClient produceMongoClient() {
        MongoClientSettings build = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();
        return MongoClients.create(build);

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
