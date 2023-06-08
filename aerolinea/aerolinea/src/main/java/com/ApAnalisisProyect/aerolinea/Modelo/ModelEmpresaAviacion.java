package com.ApAnalisisProyect.aerolinea.Modelo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_empresa_aviacion")
public class ModelEmpresaAviacion {
    @Id
    @Column(name = "cod_empresa")
    private String codEmpresa;

    @ManyToOne
    @JoinColumn(name = "num_vuelo")
    private ModelVuelo vuelo;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "hora_compra")
    private Date horaCompra;

    // Getters y Setters

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public ModelVuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(ModelVuelo vuelo) {
        this.vuelo = vuelo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(Date horaCompra) {
        this.horaCompra = horaCompra;
    }
}
