package com.ApAnalisisProyect.aerolinea.Interfaces;


import com.ApAnalisisProyect.aerolinea.Modelo.ModelEquipaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfaceEquipaje extends JpaRepository<ModelEquipaje, Integer> {
    // No es necesario agregar métodos personalizados en este caso
}
