package com.example.springdemo2.cache;


import com.example.springdemo2.Entity.CacheEntity;
import com.example.springdemo2.Repository.CacheRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class AppCache {


    public enum Keys{
         WEATHER_API;
    }

    private final CacheRepo cacheRepo;
    public HashMap<String,String> cache;

    public AppCache(CacheRepo cacheRepo){
        this.cacheRepo = cacheRepo;
    }

    @PostConstruct
    public void init(){
        cache = new HashMap<>();
        List<CacheEntity> caches = cacheRepo.findAll();
        for(CacheEntity c: caches){
            cache.put(c.getKey(),c.getValue());
        }
    }


}
