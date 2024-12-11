package com.example.springdemo2.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "Journal_Collection")
public class JournalEntity {
    @Id
    private String id;
    private String author;
    private int year;
}
