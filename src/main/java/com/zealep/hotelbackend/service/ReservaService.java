package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.Reserva;

import java.util.List;

public interface ReservaService {

    Reserva findById(Long id);

    List<Reserva> findAll();

    List<Reserva> findAllActives();

    Reserva save(Reserva c);

    Reserva update(Reserva c);

    void deleteById(Long id);

    boolean isExist(Reserva c);

}
