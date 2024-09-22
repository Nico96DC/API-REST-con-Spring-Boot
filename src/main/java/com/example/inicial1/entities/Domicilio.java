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
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Calle")
    private String calle;

    @Column(name = "Número")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    @JoinColumn(name = "fk_domicilio")
    private Persona persona;

    @OneToMany
    @Builder.Default
    @ToString.Exclude
    private List<Localidad> localidades = new ArrayList<>();
}