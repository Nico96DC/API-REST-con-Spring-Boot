package com.example.inicial1.controllers;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.services.LocalidadServicesImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServicesImpl> {
}
