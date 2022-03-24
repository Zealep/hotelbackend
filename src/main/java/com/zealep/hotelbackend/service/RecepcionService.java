package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Recepcion;

import java.util.List;

public interface RecepcionService {

    Recepcion findById(Long id);

    List<Recepcion> findAll();

    List<Recepcion> findAllActives();

    Recepcion save(Recepcion c);

    Recepcion update(Recepcion c);

    void deleteById(Long id);

    boolean isExist(Recepcion c);

}
