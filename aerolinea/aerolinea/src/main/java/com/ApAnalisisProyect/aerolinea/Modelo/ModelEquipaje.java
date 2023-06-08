package com.ApAnalisisProyect.aerolinea.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "tbl_equipaje")
public class ModelEquipaje {
    @Id
    @Column(name = "id_equipaje")
    private int idEquipaje;

    @ManyToOne
    @JoinColumn(name = "num_vuelo")
    private ModelVuelo vuelo;

    @Column(name = "cantidad_bolsas")
    private int cantidadBolsas;

    @Column(name = "peso")
    private int peso;

    // Getters y Setters

    public int getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(int idEquipaje) {
        this.idEquipaje = idEquipaje;
    }

    public ModelVuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(ModelVuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getCantidadBolsas() {
        return cantidadBolsas;
    }

    public void setCantidadBolsas(int cantidadBolsas) {
        this.cantidadBolsas = cantidadBolsas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
