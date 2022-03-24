package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Caja;
import com.zealep.hotelbackend.model.CategoriaHabitacion;

import java.util.List;

public interface CategoriaHabitacionService {

    CategoriaHabitacion findById(Long id);

    List<CategoriaHabitacion> findAll();

    List<CategoriaHabitacion> findAllActives();

    CategoriaHabitacion save(CategoriaHabitacion c);

    CategoriaHabitacion update(CategoriaHabitacion c);

    void deleteById(Long id);

    boolean isExist(CategoriaHabitacion c);

}
