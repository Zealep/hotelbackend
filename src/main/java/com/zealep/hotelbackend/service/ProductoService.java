package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto findById(Long id);

    List<Producto> findAll();

    List<Producto> findAllActives();

    Producto save(Producto c);

    Producto update(Producto c);

    void deleteById(Long id);

    boolean isExist(Producto c);

}
