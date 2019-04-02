package com.sam.mongo.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean("myDb")
    public Mongo getClient(){

        Mongo db = new MongoClient("127.0.0.1");
        return db;
    }
}
