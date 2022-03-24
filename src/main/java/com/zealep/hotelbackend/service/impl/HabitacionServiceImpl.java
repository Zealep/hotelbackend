package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Habitacion;
import com.zealep.hotelbackend.repository.HabitacionRepository;
import com.zealep.hotelbackend.service.HabitacionService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("habitacionService ")
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public Habitacion findById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Habitacion> findAll() {
        return (List<Habitacion>) habitacionRepository.findAll();
    }

    @Override
    public List<Habitacion> findAllActives() {
        return habitacionRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public List<Habitacion> findByNivel(Long id) {
        return habitacionRepository.findByNivel(id,Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Habitacion save(Habitacion c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return habitacionRepository.save(c);
    }

    @Override
    public Habitacion update(Habitacion c) {
        return habitacionRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        habitacionRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Habitacion c) {
        return findById(c.getIdHabitacion())!=null;
    }
}
