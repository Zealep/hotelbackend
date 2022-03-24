package com.zealep.hotelbackend.controller;

import com.zealep.hotelbackend.model.Recepcion;
import com.zealep.hotelbackend.service.RecepcionService;
import com.zealep.hotelbackend.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recepcion")
public class RecepcionController {

    @Autowired
    RecepcionService recepcionService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recepcion>> listar() {
        try {
            return new ResponseEntity<List<Recepcion>>(recepcionService.findAllActives(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recepcion> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<Recepcion>(recepcionService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> registrar(@RequestBody Recepcion x) {
        try {
            Recepcion c = recepcionService.save(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", c.getIdRecepcion(),""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> actualizar(@RequestBody Recepcion x) {
        try {
            recepcionService.update(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> eliminar(@PathVariable long id) {
        try {
            recepcionService.deleteById(id);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
