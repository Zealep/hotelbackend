package com.zealep.hotelbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_nivel")
    private Long idNivel;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
