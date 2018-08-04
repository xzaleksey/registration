package com.avalyakin.registration.mongo.config;

import com.mongodb.MongoClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SpringMongoConfig {

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(new MongoClient(), "database");
    }
}
