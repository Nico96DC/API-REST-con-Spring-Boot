package com.example.inicial1.controllers;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.services.DomicilioServicesImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServicesImpl> {
}