package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Egreso;

import java.util.List;

public interface EgresoService {

    Egreso findById(Long id);

    List<Egreso> findAll();

    List<Egreso> findAllActives();

    Egreso save(Egreso c);

    Egreso update(Egreso c);

    void deleteById(Long id);

    boolean isExist(Egreso c);

}
