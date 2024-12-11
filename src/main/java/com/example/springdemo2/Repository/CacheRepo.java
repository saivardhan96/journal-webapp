package com.example.springdemo2.Repository;

import com.example.springdemo2.Entity.CacheEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CacheRepo extends MongoRepository<CacheEntity,String> {

}
