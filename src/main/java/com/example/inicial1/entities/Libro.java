package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
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
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Título")
    private String titulo;

    @Column(name = "Fecha")
    private int fecha;

    @Column(name = "Género")
    private String genero;

    @Column(name = "Páginas")
    private int pag;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @Builder.Default
    @ToString.Exclude
    private List<Autor> autores = new ArrayList<>();
}