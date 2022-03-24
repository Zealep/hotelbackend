package com.zealep.hotelbackend.controller;

import com.zealep.hotelbackend.model.CategoriaHabitacion;
import com.zealep.hotelbackend.service.CategoriaHabitacionService;
import com.zealep.hotelbackend.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaHabitacionController {

    @Autowired
    CategoriaHabitacionService categoriaHabitacionService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoriaHabitacion>> listar() {
        try {
            return new ResponseEntity<List<CategoriaHabitacion>>(categoriaHabitacionService.findAllActives(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaHabitacion> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<CategoriaHabitacion>(categoriaHabitacionService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> registrar(@RequestBody CategoriaHabitacion x) {
        try {
            CategoriaHabitacion c = categoriaHabitacionService.save(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", c.getIdCategoria(),""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> actualizar(@RequestBody CategoriaHabitacion x) {
        try {
            categoriaHabitacionService.update(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> eliminar(@PathVariable long id) {
        try {
            categoriaHabitacionService.deleteById(id);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
