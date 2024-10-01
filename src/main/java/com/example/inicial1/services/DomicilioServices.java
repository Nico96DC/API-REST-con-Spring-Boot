package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServices extends BaseServiceImpl<Domicilio, Long> {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServices(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }
}