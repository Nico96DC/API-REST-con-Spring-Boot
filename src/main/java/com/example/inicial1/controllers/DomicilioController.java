package com.example.inicial1.controllers;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import com.example.inicial1.services.DomicilioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/domicilio")
public class DomicilioController {
    @Autowired
    private DomicilioServices servicio;

    public DomicilioController(DomicilioServices servicio) {
        this.servicio = servicio;
    }

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
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.findbyId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("{\"error\":\"Error. Por favor, intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Domicilio entity){
        try {
            System.out.println("Datos tomados del cuerpo del formulario");
            System.out.println("Calle:" + entity.getCalle());
            System.out.println("Numero:" + entity.getNumero());
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Domicilio entity) {
        try {
            System.out.println("ID tomada de la url " + entity.getId());
            System.out.println("Datos tomados del cuerpo del formulario");
            System.out.println("Calle:" + entity.getCalle());
            System.out.println("Numero:" + entity.getNumero());
            return ResponseEntity.status(HttpStatus.OK).
                    body(servicio.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).
                    body(servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body("{\"error\":\"Error de solicitud. Por favor, intente de nuevo más tarde\"}");
        }
    }
}