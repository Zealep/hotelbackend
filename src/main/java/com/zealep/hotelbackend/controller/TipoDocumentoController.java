package com.zealep.hotelbackend.controller;

import com.zealep.hotelbackend.model.TipoDocumento;
import com.zealep.hotelbackend.service.TipoDocumentoService;
import com.zealep.hotelbackend.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {

    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoDocumento>> listar() {
        try {
            return new ResponseEntity<List<TipoDocumento>>(tipoDocumentoService.findAllActives(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoDocumento> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<TipoDocumento>(tipoDocumentoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> registrar(@RequestBody TipoDocumento x) {
        try {
            TipoDocumento c = tipoDocumentoService.save(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", c.getIdTipoDocumento(),""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> actualizar(@RequestBody TipoDocumento x) {
        try {
            tipoDocumentoService.update(x);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK", null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> eliminar(@PathVariable long id) {
        try {
            tipoDocumentoService.deleteById(id);
            return new ResponseEntity<ResponseApi>(new ResponseApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
