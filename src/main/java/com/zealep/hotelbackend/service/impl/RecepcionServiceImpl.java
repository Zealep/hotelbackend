package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Recepcion;
import com.zealep.hotelbackend.repository.RecepcionRepository;
import com.zealep.hotelbackend.service.RecepcionService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recepcionService ")
public class RecepcionServiceImpl implements RecepcionService {

    @Autowired
    private RecepcionRepository recepcionRepository;

    @Override
    public Recepcion findById(Long id) {
        return recepcionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recepcion> findAll() {
        return (List<Recepcion>) recepcionRepository.findAll();
    }

    @Override
    public List<Recepcion> findAllActives() {
        return recepcionRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Recepcion save(Recepcion c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return recepcionRepository.save(c);
    }

    @Override
    public Recepcion update(Recepcion c) {
        return recepcionRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        recepcionRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Recepcion c) {
        return findById(c.getIdRecepcion())!=null;
    }
}
