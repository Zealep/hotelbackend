package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.TipoDocumento;
import com.zealep.hotelbackend.repository.TipoDocumentoRepository;
import com.zealep.hotelbackend.service.TipoDocumentoService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tipoDocumentoService ")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public TipoDocumento findById(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(null);
    }

    @Override
    public List<TipoDocumento> findAll() {
        return (List<TipoDocumento>) tipoDocumentoRepository.findAll();
    }

    @Override
    public List<TipoDocumento> findAllActives() {
        return tipoDocumentoRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public TipoDocumento save(TipoDocumento c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return tipoDocumentoRepository.save(c);
    }

    @Override
    public TipoDocumento update(TipoDocumento c) {
        return tipoDocumentoRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        tipoDocumentoRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(TipoDocumento c) {
        return findById(c.getIdTipoDocumento())!=null;
    }
}
