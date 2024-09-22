package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServices implements BaseService<Domicilio> {
    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List<Domicilio> findAll() throws Exception {
        try{
            return domicilioRepository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findbyId(Long id) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception();
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try{
            entity = domicilioRepository.save(entity);
            return entity;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            if (entityOptional.isPresent()) {
                Domicilio domicilio = entityOptional.get();
                domicilio.setCalle(entity.getCalle());
                domicilio.setNumero(entity.getNumero());
                domicilio = domicilioRepository.save(domicilio);
                return domicilio;
            } else {
                throw new Exception();
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}