package com.example.springdemo2.Service;


import com.example.springdemo2.Entity.JournalEntity;
import com.example.springdemo2.Entity.UserEntity;
import com.example.springdemo2.Repository.JournalRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class JournalService {

    private final JournalRepo journalRepo;
    private final UserService userService;

    public JournalService(JournalRepo journalRepo, UserService userService) {
        this.journalRepo = journalRepo;
        this.userService = userService;
    }

    public List<JournalEntity> getJournals(){
        return journalRepo.findAll();
    }

    public Optional<JournalEntity> getJournalById(String id, String username){
        UserEntity user = userService.findByUserName(username);
        return user.getJournals().stream().filter( j -> Objects.equals(j.getId(),id)).findFirst();
    }

    @Transactional
    public void saveJournal(JournalEntity journalEntity, String username){
        UserEntity user = userService.findByUserName(username);
        JournalEntity saved = journalRepo.save(journalEntity);
        user.getJournals().add(saved);
        userService.saveUser(user);
    }

    public void deleteById(String id, String username){
        UserEntity user = userService.findByUserName(username);
        boolean isRemoved = user.getJournals().removeIf(x -> x.getId().equals(id));
        if(!isRemoved) throw new UsernameNotFoundException("Journal with id - " +id + " doesn't exist");
        userService.saveUser(user);
        journalRepo.deleteById(id);
    }

    public void deleteById(String id){
        journalRepo.deleteById(id);
    }

}
