package com.ApAnalisisProyect.aerolinea.Interfaces;

import com.ApAnalisisProyect.aerolinea.Modelo.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InterfaceUsuario extends JpaRepository<ModelUsuario, Integer> {
    Optional<ModelUsuario> findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
