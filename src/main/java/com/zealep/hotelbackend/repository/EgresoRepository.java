package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.CategoriaHabitacion;
import com.zealep.hotelbackend.model.Egreso;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EgresoRepository extends CrudRepository<Egreso,Long> {

    @Query("select e from Egreso e where e.estado=?1")
    public List<Egreso> findAllActives(String active);

    @Modifying
    @Query("update Egreso e set e.estado=?1 where e.idEgreso=?2 ")
    public void deleteLogicById(String estado,Long id);
}
