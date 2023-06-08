package com.ApAnalisisProyect.aerolinea.Modelo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_vuelo")
public class ModelVuelo {
    @Id
    @Column(name = "num_reservacion")
    private int numReservacion;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private ModelPersona persona;

    @Column(name = "num_vuelo")
    private int numVuelo;

    @Column(name = "clase_vuelo")
    private String claseVuelo;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private Date hora;

    @Column(name = "tiempo_abordaje")
    private Date tiempoAbordaje;

    @Column(name = "puerta")
    private String puerta;

    // Getters y Setters

    public int getNumReservacion() {
        return numReservacion;
    }

    public void setNumReservacion(int numReservacion) {
        this.numReservacion = numReservacion;
    }

    public ModelPersona getPersona() {
        return persona;
    }

    public void setPersona(ModelPersona persona) {
        this.persona = persona;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getTiempoAbordaje() {
        return tiempoAbordaje;
    }

    public void setTiempoAbordaje(Date tiempoAbordaje) {
        this.tiempoAbordaje = tiempoAbordaje;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }
}

