package com.lms.bookmanagement.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
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


