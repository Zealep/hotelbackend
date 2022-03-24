package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.Producto;
import com.zealep.hotelbackend.repository.ProductoRepository;
import com.zealep.hotelbackend.service.ProductoService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productoService ")
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public List<Producto> findAllActives() {
        return productoRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Producto save(Producto c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return productoRepository.save(c);
    }

    @Override
    public Producto update(Producto c) {
        return productoRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Producto c) {
        return findById(c.getIdProducto())!=null;
    }
}
