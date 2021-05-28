package com.lms.bookmanagement.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    private String title;
    private String description;
    private String author;
    private int publishYear;
    private int cost;
    private int purchaseDate;
    private long Id;


}


