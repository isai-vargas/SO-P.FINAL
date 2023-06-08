package com.ApAnalisisProyect.aerolinea.Controladores;

import com.ApAnalisisProyect.aerolinea.Interfaces.InterfaceEquipaje;
import com.ApAnalisisProyect.aerolinea.Modelo.ModelEquipaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipajes")
public class EquipajeController {
    @Autowired
    private InterfaceEquipaje equipajeRepository;

    @GetMapping
    public List<ModelEquipaje> getAllEquipajes() {
        return equipajeRepository.findAll();
    }

    @GetMapping("/{idEquipaje}")
    public ResponseEntity<ModelEquipaje> getEquipajeById(@PathVariable int idEquipaje) {
        Optional<ModelEquipaje> equipaje = equipajeRepository.findById(idEquipaje);
        if (equipaje.isPresent()) {
            return ResponseEntity.ok(equipaje.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelEquipaje> insertEquipaje(@RequestBody ModelEquipaje equipaje) {
        ModelEquipaje newEquipaje = equipajeRepository.save(equipaje);
        return ResponseEntity.ok(newEquipaje);
    }

    @PutMapping("/{idEquipaje}")
    public ResponseEntity<ModelEquipaje> updateEquipaje(@PathVariable int idEquipaje, @RequestBody ModelEquipaje equipaje) {
        Optional<ModelEquipaje> equipajeOptional = equipajeRepository.findById(idEquipaje);

        if (equipajeOptional.isPresent()) {
            ModelEquipaje existingEquipaje = equipajeOptional.get();
            existingEquipaje.setVuelo(equipaje.getVuelo());
            existingEquipaje.setCantidadBolsas(equipaje.getCantidadBolsas());
            existingEquipaje.setPeso(equipaje.getPeso());

            ModelEquipaje updatedEquipaje = equipajeRepository.save(existingEquipaje);
            return ResponseEntity.ok(updatedEquipaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEquipaje}")
    public ResponseEntity<String> deleteEquipajeById(@PathVariable int idEquipaje) {
        Optional<ModelEquipaje> equipaje = equipajeRepository.findById(idEquipaje);
        if (equipaje.isPresent()) {
            equipajeRepository.delete(equipaje.get());
            return ResponseEntity.ok("Equipaje deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

