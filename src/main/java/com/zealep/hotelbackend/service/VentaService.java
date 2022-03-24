package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Venta;

import java.util.List;

public interface VentaService {

    Venta findById(Long id);

    List<Venta> findAll();

    List<Venta> findAllActives();

    Venta save(Venta c);

    Venta update(Venta c);

    void deleteById(Long id);

    boolean isExist(Venta c);

}
