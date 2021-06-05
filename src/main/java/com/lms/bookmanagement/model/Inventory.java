package com.lms.bookmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {


    @Id
    private long id;
    private int inventoryCount;

    @OneToOne
    private Book book;



}
