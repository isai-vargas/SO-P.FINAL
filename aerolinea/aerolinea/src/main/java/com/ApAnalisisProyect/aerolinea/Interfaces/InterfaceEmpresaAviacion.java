package com.ApAnalisisProyect.aerolinea.Interfaces;


import com.ApAnalisisProyect.aerolinea.Modelo.ModelEmpresaAviacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfaceEmpresaAviacion extends JpaRepository<ModelEmpresaAviacion, String> {
    // No es necesario agregar métodos personalizados en este caso
}
