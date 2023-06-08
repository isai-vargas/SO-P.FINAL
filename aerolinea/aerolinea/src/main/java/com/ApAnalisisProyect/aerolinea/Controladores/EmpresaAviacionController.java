package com.ApAnalisisProyect.aerolinea.Controladores;

import com.ApAnalisisProyect.aerolinea.Interfaces.InterfaceEmpresaAviacion;
import com.ApAnalisisProyect.aerolinea.Modelo.ModelEmpresaAviacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas-aviacion")
public class EmpresaAviacionController {
    @Autowired
    private InterfaceEmpresaAviacion empresaAviacionRepository;

    @GetMapping
    public List<ModelEmpresaAviacion> getAllEmpresasAviacion() {
        return empresaAviacionRepository.findAll();
    }

    @GetMapping("/{codEmpresa}")
    public ResponseEntity<ModelEmpresaAviacion> getEmpresaAviacionByCodEmpresa(@PathVariable String codEmpresa) {
        Optional<ModelEmpresaAviacion> empresaAviacion = empresaAviacionRepository.findById(codEmpresa);
        if (empresaAviacion.isPresent()) {
            return ResponseEntity.ok(empresaAviacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelEmpresaAviacion> insertEmpresaAviacion(@RequestBody ModelEmpresaAviacion empresaAviacion) {
        ModelEmpresaAviacion newEmpresaAviacion = empresaAviacionRepository.save(empresaAviacion);
        return ResponseEntity.ok(newEmpresaAviacion);
    }

    @PutMapping("/{codEmpresa}")
    public ResponseEntity<ModelEmpresaAviacion> updateEmpresaAviacion(@PathVariable String codEmpresa, @RequestBody ModelEmpresaAviacion empresaAviacion) {
        Optional<ModelEmpresaAviacion> empresaAviacionOptional = empresaAviacionRepository.findById(codEmpresa);

        if (empresaAviacionOptional.isPresent()) {
            ModelEmpresaAviacion existingEmpresaAviacion = empresaAviacionOptional.get();
            existingEmpresaAviacion.setVuelo(empresaAviacion.getVuelo());
            existingEmpresaAviacion.setCodigoBarras(empresaAviacion.getCodigoBarras());
            existingEmpresaAviacion.setDepartamento(empresaAviacion.getDepartamento());
            existingEmpresaAviacion.setFechaCompra(empresaAviacion.getFechaCompra());
            existingEmpresaAviacion.setHoraCompra(empresaAviacion.getHoraCompra());

            ModelEmpresaAviacion updatedEmpresaAviacion = empresaAviacionRepository.save(existingEmpresaAviacion);
            return ResponseEntity.ok(updatedEmpresaAviacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codEmpresa}")
    public ResponseEntity<String> deleteEmpresaAviacionByCodEmpresa(@PathVariable String codEmpresa) {
        Optional<ModelEmpresaAviacion> empresaAviacion = empresaAviacionRepository.findById(codEmpresa);
        if (empresaAviacion.isPresent()) {
            empresaAviacionRepository.delete(empresaAviacion.get());
            return ResponseEntity.ok("Empresa de Aviación deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

