package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Recepcion;
import com.zealep.hotelbackend.model.Reserva;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReservaRepository extends CrudRepository<Reserva,Long> {

    @Query("select e from Reserva e where e.estado=?1")
    public List<Reserva> findAllActives(String active);

    @Modifying
    @Query("update Reserva e set e.estado=?1 where e.idReserva=?2 ")
    public void deleteLogicById(String estado,Long id);
}
