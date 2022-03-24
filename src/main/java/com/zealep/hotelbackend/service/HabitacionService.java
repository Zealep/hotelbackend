package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Habitacion;

import java.util.List;

public interface HabitacionService {

    Habitacion findById(Long id);

    List<Habitacion> findAll();

    List<Habitacion> findAllActives();

    List<Habitacion> findByNivel(Long id);

    Habitacion save(Habitacion c);

    Habitacion update(Habitacion c);

    void deleteById(Long id);

    boolean isExist(Habitacion c);

}
