package com.zealep.hotelbackend.controller;

import com.zealep.hotelbackend.model.Habitacion;
import com.zealep.hotelbackend.service.HabitacionService;
import com.zealep.hotelbackend.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    HabitacionService habitacionService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Habitacion>> listar() {
        try {
            return new ResponseEntity<List<Habitacion>>(habitacionService.findAllActives(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Habitacion> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<Habitacion>(habitacionService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/find/nivel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Habitacion>> buscarPorNivel(@PathVariable Long id) {
        try {
            return new ResponseEntity<List<Habitacion>>(habitacionService.findByNivel(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> registrar(@RequestBody Habitacion x) {
        try {
            Habitacion c = habitacionService.save(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", c.getIdHabitacion(),""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> actualizar(@RequestBody Habitacion x) {
        try {
            habitacionService.update(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> eliminar(@PathVariable long id) {
        try {
            habitacionService.deleteById(id);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
