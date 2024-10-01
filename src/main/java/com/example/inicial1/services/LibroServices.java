package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.repositories.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServices implements BaseService<Libro> {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
        try{
            return libroRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Transactional
    public List<Libro> findByPersonaId(Long personaId) {
        return libroRepository.findByPersonaId(personaId);
    }

    @Override
    @Transactional
    public Libro findbyId(Long id) throws Exception {
        try{
            Optional<Libro> entityOptional = libroRepository.findById(id);
            return entityOptional.get();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try{
            entity = libroRepository.save(entity);
            return entity;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try{
            Optional<Libro> entityOptional = libroRepository.findById(id);
            Libro libro = entityOptional.get();
            libro.setTitulo(entity.getTitulo());
            libro.setFecha(entity.getFecha());
            libro.setGenero(entity.getGenero());
            libro.setPag(entity.getPag());
            libro = libroRepository.save(libro);
            return libro;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (libroRepository.existsById(id)){
                libroRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
