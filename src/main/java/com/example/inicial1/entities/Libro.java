package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
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
@Builder
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

    @ManyToOne
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "fk_libro"),
            inverseJoinColumns = @JoinColumn(name = "fk_autor")
    )
    @Builder.Default
    @ToString.Exclude
    private List<Autor> autores = new ArrayList<>();
}