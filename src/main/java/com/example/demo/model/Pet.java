package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @NotBlank(message="El nombre no puede estar en blanco")
    private  String nombre;
    @NotBlank(message="La especie no puede estar en blanco")
    private String especie;
    @NotNull(message= "La edad no puede estar vacia")
    private int edad;

    @ManyToOne
    private Owner owner;


}
