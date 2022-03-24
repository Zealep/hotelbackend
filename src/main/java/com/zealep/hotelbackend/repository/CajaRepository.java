package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Caja;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CajaRepository extends CrudRepository<Caja,Long> {

    @Query("select e from Caja e where e.estado=?1")
    public List<Caja> findAllActives(String active);

    @Modifying
    @Query("update Caja e set e.estado=?1 where e.idCaja=?2 ")
    public void deleteLogicById(String estado,Long id);
}
