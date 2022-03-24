package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.TipoDocumento;
import com.zealep.hotelbackend.model.Venta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VentaRepository extends CrudRepository<Venta,Long> {

    @Query("select e from Venta e where e.estado=?1")
    public List<Venta> findAllActives(String active);

    @Modifying
    @Query("update Venta e set e.estado=?1 where e.idVenta=?2 ")
    public void deleteLogicById(String estado,Long id);
}
