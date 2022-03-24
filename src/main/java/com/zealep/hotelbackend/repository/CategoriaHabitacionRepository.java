package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Caja;
import com.zealep.hotelbackend.model.CategoriaHabitacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoriaHabitacionRepository extends CrudRepository<CategoriaHabitacion,Long> {

    @Query("select e from CategoriaHabitacion e where e.estado=?1")
    public List<CategoriaHabitacion> findAllActives(String active);

    @Modifying
    @Query("update CategoriaHabitacion e set e.estado=?1 where e.idCategoria=?2 ")
    public void deleteLogicById(String estado,Long id);
}
