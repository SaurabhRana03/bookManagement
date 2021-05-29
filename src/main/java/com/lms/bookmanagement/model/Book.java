package com.lms.bookmanagement.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    private long Id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String author;
    @Column
    private int publishYear;
    @Column
    private int cost;
    @Column
    private int purchaseDate;



}


