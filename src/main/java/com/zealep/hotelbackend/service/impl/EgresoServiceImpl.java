package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Egreso;
import com.zealep.hotelbackend.repository.EgresoRepository;
import com.zealep.hotelbackend.service.EgresoService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("egresoService")
public class EgresoServiceImpl implements EgresoService {

    @Autowired
    private EgresoRepository egresoRepository;

    @Override
    public Egreso findById(Long id) {
        return egresoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Egreso> findAll() {
        return (List<Egreso>) egresoRepository.findAll();
    }

    @Override
    public List<Egreso> findAllActives() {
        return egresoRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Egreso save(Egreso c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return egresoRepository.save(c);
    }

    @Override
    public Egreso update(Egreso c) {
        return egresoRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        egresoRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Egreso c) {
        return findById(c.getIdEgreso())!=null;
    }
}
