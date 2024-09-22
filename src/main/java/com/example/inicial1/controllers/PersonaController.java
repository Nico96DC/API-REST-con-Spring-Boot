package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.services.PersonaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaServices servicio;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error. Por favor, intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.findbyId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error. Por favor, intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity){
        System.out.println("Datos tomados del cuerpo del formulario");
        System.out.println("Nombre:" + entity.getNombre());
        System.out.println("Apellido:" + entity.getApellido());
        System.out.println("DNI:" + entity.getDni());
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity){
        System.out.println("ID tomada de la url " + entity.getId());
        System.out.println("Datos tomados del cuerpo del Formulario");
        System.out.println("Nombre:" + entity.getNombre());
        System.out.println("Apellido:" + entity.getApellido());
        System.out.println("DNI:" + entity.getDni());
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).
                    body("Registro " + id + " eliminado");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }
}