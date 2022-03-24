package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Habitacion;
import com.zealep.hotelbackend.model.Nivel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface NivelRepository extends CrudRepository<Nivel,Long> {

    @Query("select e from Nivel e where e.estado=?1")
    public List<Nivel> findAllActives(String active);

    @Modifying
    @Query("update Nivel e set e.estado=?1 where e.idNivel=?2 ")
    public void deleteLogicById(String estado,Long id);
}
