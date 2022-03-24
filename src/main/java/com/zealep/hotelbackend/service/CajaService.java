package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Caja;

import java.util.List;

public interface CajaService {

    Caja findById(Long id);

    List<Caja> findAll();

    List<Caja> findAllActives();

    Caja save(Caja c);

    Caja update(Caja c);

    void deleteById(Long id);

    boolean isExist(Caja c);

}
