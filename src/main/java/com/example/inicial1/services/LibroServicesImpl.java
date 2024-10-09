package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicesImpl extends BaseServiceImpl<Libro, Long> implements LibroServices {
    @Autowired
    private LibroRepository libroRepository;

    public LibroServicesImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }
}
