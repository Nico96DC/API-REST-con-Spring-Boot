package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
    List<Libro> findByPersonaId(Long personaId);
}
