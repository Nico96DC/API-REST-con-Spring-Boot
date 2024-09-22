package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Nombre")
    private String apellido;

    @Column(name = "Biografía")
    private String bio;

    @ManyToMany(mappedBy = "autores")
    @Builder.Default
    @ToString.Exclude
    private List<Libro> libros = new ArrayList<>();
}