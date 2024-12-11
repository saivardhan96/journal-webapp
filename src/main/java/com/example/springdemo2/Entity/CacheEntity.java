package com.example.springdemo2.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "App_config")
public class CacheEntity {
    private String key;
    private String value;
}
