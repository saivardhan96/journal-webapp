package com.example.springdemo2.Service;


import com.example.springdemo2.Entity.JournalEntity;
import com.example.springdemo2.Entity.UserEntity;
import com.example.springdemo2.Repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    private final UserRepo userRepo;
    private final JournalService journalService;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo, JournalService journalService) {
        this.userRepo = userRepo;
        this.journalService = journalService;
    }

    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }

    public UserEntity findByUserName(String username){
        return userRepo.findByUsername(username);
    }

    public Optional<UserEntity> getUserById(String id){
        return userRepo.findById(id);
    }

    public void saveUser(UserEntity userEntity){
        userRepo.save(userEntity);
    }

    public ResponseEntity<UserEntity> saveNewUSer(UserEntity user){
        if(findByUserName(user.getUsername())==null){
            user.setRoles(List.of("USER"));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    public void saveNewAdmin(UserEntity user){
        user.setRoles(List.of("ADMIN"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }


    public void updateUser(UserEntity newUser , String username){
        boolean passChange = false;
        UserEntity userInDb = userRepo.findByUsername(username);
        userInDb.setUsername(newUser.getUsername());
        userInDb.setPassword(newUser.getPassword());
        saveNewUSer(userInDb);
    }

    public void deleteByUsername(String username){
        UserEntity user = userRepo.findByUsername(username);
        for(JournalEntity j : user.getJournals()){
            journalService.deleteById(j.getId());
        }
        userRepo.delete(user);
    }
}
