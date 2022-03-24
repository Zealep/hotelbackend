package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Egreso;
import com.zealep.hotelbackend.model.Habitacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HabitacionRepository extends CrudRepository<Habitacion,Long> {

    @Query("select e from Habitacion e where e.estado=?1")
    public List<Habitacion> findAllActives(String active);

    @Query("select e from Habitacion e where e.nivel.idNivel=?1 and e.estado=?2")
    public List<Habitacion> findByNivel(Long idNivel,String active);

    @Modifying
    @Query("update Habitacion e set e.estado=?1 where e.idHabitacion=?2 ")
    public void deleteLogicById(String estado,Long id);
}
