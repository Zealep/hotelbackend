package com.zealep.hotelbackend.service.impl;

import com.zealep.hotelbackend.model.TipoDocumento;
import com.zealep.hotelbackend.model.Usuario;
import com.zealep.hotelbackend.repository.TipoDocumentoRepository;
import com.zealep.hotelbackend.repository.UsuarioRepository;
import com.zealep.hotelbackend.service.TipoDocumentoService;
import com.zealep.hotelbackend.service.UsuarioService;
import com.zealep.hotelbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioService ")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllActives() {
        return usuarioRepository.findAllActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Usuario save(Usuario c) {
        c.setEstado(Constantes.ESTADO_ACTIVO);
        return usuarioRepository.save(c);
    }

    @Override
    public Usuario update(Usuario c) {
        return usuarioRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteLogicById(Constantes.ESTADO_INACTIVO,id);
    }

    @Override
    public boolean isExist(Usuario c) {
        return findById(c.getIdUsuario())!=null;
    }
}
