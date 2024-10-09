package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServicesImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadServices {
    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServicesImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
