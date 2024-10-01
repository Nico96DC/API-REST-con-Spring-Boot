package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadServices implements BaseService<Localidad> {
    @Autowired
    private LocalidadRepository localidadRepository;

    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try{
            return localidadRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findbyId(Long id) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            return entityOptional.get();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try{
            entity = localidadRepository.save(entity);
            return entity;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            Localidad localidad = entityOptional.get();
            localidad.setDenominacion(entity.getDenominacion());
            localidad = localidadRepository.save(localidad);
            return localidad;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
