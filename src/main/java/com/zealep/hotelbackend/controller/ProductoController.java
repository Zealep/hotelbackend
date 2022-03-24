package com.zealep.hotelbackend.controller;

import com.zealep.hotelbackend.model.Producto;
import com.zealep.hotelbackend.service.ProductoService;
import com.zealep.hotelbackend.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listar() {
        try {
            return new ResponseEntity<List<Producto>>(productoService.findAllActives(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<Producto>(productoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> registrar(@RequestBody Producto x) {
        try {
            Producto c = productoService.save(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", c.getIdProducto(),""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> actualizar(@RequestBody Producto x) {
        try {
            productoService.update(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> eliminar(@PathVariable long id) {
        try {
            productoService.deleteById(id);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
