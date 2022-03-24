package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Nivel;
import com.zealep.hotelbackend.model.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductoRepository extends CrudRepository<Producto,Long> {

    @Query("select e from Producto e where e.estado=?1")
    public List<Producto> findAllActives(String active);

    @Modifying
    @Query("update Producto e set e.estado=?1 where e.idProducto=?2 ")
    public void deleteLogicById(String estado,Long id);
}
