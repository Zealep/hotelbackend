package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Caja;
import com.zealep.hotelbackend.repository.CajaRepository;
import com.zealep.hotelbackend.service.CajaService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cajaService")
public class CajaServiceImpl implements CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public Caja findById(Long id) {
        return cajaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Caja> findAll() {
        return (List<Caja>) cajaRepository.findAll();
    }

    @Override
    public List<Caja> findAllActives() {
        return cajaRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Caja save(Caja c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return cajaRepository.save(c);
    }

    @Override
    public Caja update(Caja c) {
        return cajaRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        cajaRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Caja c) {
        return findById(c.getIdCaja())!=null;
    }
}
