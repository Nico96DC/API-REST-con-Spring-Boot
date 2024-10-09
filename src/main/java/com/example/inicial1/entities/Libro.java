package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Libro extends Base {
    @Column(name = "Título")
    private String titulo;

    @Column(name = "Fecha")
    private int fecha;

    @Column(name = "Género")
    private String genero;

    @Column(name = "Páginas")
    private int pag;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}