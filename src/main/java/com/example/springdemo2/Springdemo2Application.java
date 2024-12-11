package com.example.springdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Springdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo2Application.class, args);
        System.out.println("Hello, Kittu!!!");
    }

    @Bean
    public PlatformTransactionManager sai(MongoDatabaseFactory db){
        return new MongoTransactionManager(db);
    }

}

