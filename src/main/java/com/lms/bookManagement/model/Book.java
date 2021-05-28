package com.lms.bookManagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Book implements Serializable {

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


