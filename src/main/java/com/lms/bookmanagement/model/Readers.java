package com.lms.bookmanagement.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Readers")
public class Readers implements Serializable {

    @Id
    private long id;
    private String name;
    private int mobileNumber;
    private String email;
    private String address;
    private double enrollmentFee;



}
