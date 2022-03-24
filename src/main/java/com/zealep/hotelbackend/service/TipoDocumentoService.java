package com.zealep.hotelbackend.service;

import com.zealep.hotelbackend.model.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    TipoDocumento findById(Long id);

    List<TipoDocumento> findAll();

    List<TipoDocumento> findAllActives();

    TipoDocumento save(TipoDocumento c);

    TipoDocumento update(TipoDocumento c);

    void deleteById(Long id);

    boolean isExist(TipoDocumento c);

}
