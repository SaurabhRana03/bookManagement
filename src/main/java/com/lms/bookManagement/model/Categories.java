package com.lms.bookManagement.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Categories implements Serializable {
    @Id
    @GeneratedValue
    private long Id;
    private String name;
    private String description;


    public Categories(){

    }
}


