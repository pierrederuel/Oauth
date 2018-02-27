package com.example.demo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo")
public class MongoConfig extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "drivejava";
    }

    @Bean
    public Mongo mongo() {
        return new MongoClient(singletonList(new ServerAddress("ds119675.mlab.com", 19675)),
                singletonList(MongoCredential.createCredential("estiam", "drivejava", "estiam".toCharArray())));
    }
}