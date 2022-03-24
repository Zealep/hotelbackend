package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.CategoriaHabitacion;
import com.zealep.hotelbackend.repository.CategoriaHabitacionRepository;
import com.zealep.hotelbackend.service.CategoriaHabitacionService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriaHabitacionService")
public class CategoriaHabitacionServiceImpl implements CategoriaHabitacionService {

    @Autowired
    private CategoriaHabitacionRepository categoriaHabitacionRepository;

    @Override
    public CategoriaHabitacion findById(Long id) {
        return categoriaHabitacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoriaHabitacion> findAll() {
        return (List<CategoriaHabitacion>) categoriaHabitacionRepository.findAll();
    }

    @Override
    public List<CategoriaHabitacion> findAllActives() {
        return categoriaHabitacionRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public CategoriaHabitacion save(CategoriaHabitacion c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return categoriaHabitacionRepository.save(c);
    }

    @Override
    public CategoriaHabitacion update(CategoriaHabitacion c) {
        return categoriaHabitacionRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        categoriaHabitacionRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(CategoriaHabitacion c) {
        return findById(c.getIdCategoria())!=null;
    }
}
