package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Reserva;
import com.zealep.hotelbackend.repository.ReservaRepository;
import com.zealep.hotelbackend.service.ReservaService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reservaService ")
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reserva> findAll() {
        return (List<Reserva>) reservaRepository.findAll();
    }

    @Override
    public List<Reserva> findAllActives() {
        return reservaRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Reserva save(Reserva c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return reservaRepository.save(c);
    }

    @Override
    public Reserva update(Reserva c) {
        return reservaRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Reserva c) {
        return findById(c.getIdReserva())!=null;
    }
}
