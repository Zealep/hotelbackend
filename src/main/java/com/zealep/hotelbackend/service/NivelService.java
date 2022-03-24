package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Nivel;

import java.util.List;

public interface NivelService {

    Nivel findById(Long id);

    List<Nivel> findAll();

    List<Nivel> findAllActives();

    Nivel save(Nivel c);

    Nivel update(Nivel c);

    void deleteById(Long id);

    boolean isExist(Nivel c);

}
