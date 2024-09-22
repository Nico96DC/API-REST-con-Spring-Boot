package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.services.AutorServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorServices servicio;

    @Autowired
    private AutorRepository autorRepository;

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
    public ResponseEntity<?> save(@RequestBody Autor entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Autor entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.save(entity));
        } catch (Exception e) {
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
