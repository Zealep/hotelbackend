package com.zealep.hotelbackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaHabitacion categoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "precio")
    private double precio;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "estado")
    private String estado;

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public CategoriaHabitacion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaHabitacion categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
