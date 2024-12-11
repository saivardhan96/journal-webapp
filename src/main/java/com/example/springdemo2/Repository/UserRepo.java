package com.example.springdemo2.Repository;

import com.example.springdemo2.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepo extends MongoRepository<UserEntity, String> {
    public UserEntity findByUsername(String username);





}
