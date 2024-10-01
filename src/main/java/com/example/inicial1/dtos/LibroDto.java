package com.example.inicial1.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LibroDto {
    private Long id;
    private String titulo;
    private int fecha;
    private String genero;
    private int pag;
}