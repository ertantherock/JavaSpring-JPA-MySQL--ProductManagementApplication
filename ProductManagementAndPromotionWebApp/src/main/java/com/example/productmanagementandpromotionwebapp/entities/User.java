package com.example.productmanagementandpromotionwebapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String name;

    private String surname;

    private Integer age;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean status;

}
