package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Producto;
import com.zealep.hotelbackend.model.Recepcion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RecepcionRepository extends CrudRepository<Recepcion,Long> {

    @Query("select e from Recepcion e where e.estado=?1")
    public List<Recepcion> findAllActives(String active);

    @Modifying
    @Query("update Recepcion e set e.estado=?1 where e.idRecepcion=?2 ")
    public void deleteLogicById(String estado,Long id);
}
