package com.zealep.hotelbackend.repository;

import com.zealep.hotelbackend.model.Reserva;
import com.zealep.hotelbackend.model.TipoDocumento;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento,Long> {

    @Query("select e from TipoDocumento e where e.estado=?1")
    public List<TipoDocumento> findAllActives(String active);

    @Modifying
    @Query("update TipoDocumento e set e.estado=?1 where e.idTipoDocumento=?2 ")
    public void deleteLogicById(String estado,Long id);
}
