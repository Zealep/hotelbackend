package com.zealep.hotelbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "egreso")
public class Egreso implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_egreso")
    private Long idEgreso;

    @JsonSerialize(using= ToStringSerializer.class)
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "monto")
    private double monto;

    @Column(name = "estado")
    private String estado;

    public Long getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Long idEgreso) {
        this.idEgreso = idEgreso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
