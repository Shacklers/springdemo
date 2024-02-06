package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    private  String nombre;
    private String especie;
    private int edad;

    @ManyToOne
    private Owner owner;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOwner(Owner o){
        this.owner = o;
    }
}
