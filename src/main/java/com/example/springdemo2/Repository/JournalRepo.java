package com.example.springdemo2.Repository;

import com.example.springdemo2.Entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JournalRepo extends MongoRepository<JournalEntity, String> {

}
