package com.example.springdemo2.controller;


import com.example.springdemo2.Entity.JournalEntity;
import com.example.springdemo2.Service.JournalService;
import com.example.springdemo2.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/journals")
public class JournalController {

    private final JournalService journalService;
    private final UserService userService;

    public JournalController(JournalService journalService, UserService userService) {
        this.journalService = journalService;
        this.userService = userService;
    }

/*    @GetMapping // to get all the available journals
    public List<JournalEntity> getJournals(){
          return journalService.getJournals();
    }*/

    @PostMapping("/postJournal")
    public void postJournal(@RequestBody JournalEntity journal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        journalService.saveJournal(journal , username);
    }

/*    @PostMapping("/postJournal")
    public void postJournal(HttpServletRequest request){
        JournalEntity journal = new JournalEntity();
        journal.setId(request.getParameter("id"));
        journal.setYear(Integer.parseInt(request.getParameter("year")));
        journal.setAuthor(request.getParameter("name"));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        journalService.saveJournal(journal , username);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<JournalEntity> journalEntity = journalService.getJournalById(id,username);
        if(journalEntity.isPresent()) return new ResponseEntity<>(journalEntity.get() , HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteJournal/{id}")
    public ResponseEntity<JournalEntity> deleteById(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        try {
            journalService.deleteById(id, username);
        }
        catch (UsernameNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
