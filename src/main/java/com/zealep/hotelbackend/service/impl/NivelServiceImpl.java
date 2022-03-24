package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Nivel;
import com.zealep.hotelbackend.repository.NivelRepository;
import com.zealep.hotelbackend.service.NivelService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nivelService ")
public class NivelServiceImpl implements NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    @Override
    public Nivel findById(Long id) {
        return nivelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Nivel> findAll() {
        return (List<Nivel>) nivelRepository.findAll();
    }

    @Override
    public List<Nivel> findAllActives() {
        return nivelRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Nivel save(Nivel c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return nivelRepository.save(c);
    }

    @Override
    public Nivel update(Nivel c) {
        return nivelRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        nivelRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Nivel c) {
        return findById(c.getIdNivel())!=null;
    }
}
