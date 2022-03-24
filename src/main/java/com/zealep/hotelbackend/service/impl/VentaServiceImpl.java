package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Venta;
import com.zealep.hotelbackend.repository.VentaRepository;
import com.zealep.hotelbackend.service.VentaService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ventaService ")
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) ventaRepository.findAll();
    }

    @Override
    public List<Venta> findAllActives() {
        return ventaRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Venta save(Venta c) {

        c.setEstado(Constantes.ESTADO_ACTIVO);
        c.getDetalleVentas().forEach(x -> {
            x.setVenta(c);
        });
        return ventaRepository.save(c);
    }

    @Override
    public Venta update(Venta c) {
        return ventaRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Venta c) {
        return findById(c.getIdVenta())!=null;
    }
}
