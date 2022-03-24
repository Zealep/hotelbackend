package com.zealep.hotelbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "recepcion")
public class Recepcion implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_recepcion")
    private Long idRecepcion;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "tarifa_hora")
    private int tarifaHora;

    @Column(name = "precio")
    private double precio;

    @Column(name = "adelanto")
    private double adelanto;

    @JsonSerialize(using= ToStringSerializer.class)
    @Column(name = "fecha_entrada")
    private LocalDateTime fechaEntrada;

    @JsonSerialize(using= ToStringSerializer.class)
    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "late_checkout")
    private double lateCheckout;

    @Column(name = "total")
    private double total;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "estado")
    private String estado;

    public Long getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(int tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(double adelanto) {
        this.adelanto = adelanto;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getLateCheckout() {
        return lateCheckout;
    }

    public void setLateCheckout(double lateCheckout) {
        this.lateCheckout = lateCheckout;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
