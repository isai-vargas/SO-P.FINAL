package com.ApAnalisisProyect.aerolinea.Controladores;

import com.ApAnalisisProyect.aerolinea.Interfaces.InterfacePersona;
import com.ApAnalisisProyect.aerolinea.Modelo.ModelPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    private InterfacePersona personaRepository;

    @GetMapping
    public List<ModelPersona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelPersona> getPersonaById(@PathVariable int id) {
        Optional<ModelPersona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelPersona> insertPersona(@RequestBody ModelPersona persona) {
        ModelPersona newPersona = personaRepository.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelPersona> updatePersona(@PathVariable int id, @RequestBody ModelPersona persona) {
        Optional<ModelPersona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            ModelPersona existingPersona = personaOptional.get();
            existingPersona.setTitulo(persona.getTitulo());
            existingPersona.setNombre(persona.getNombre());
            existingPersona.setFechaNacimiento(persona.getFechaNacimiento());

            ModelPersona updatedPersona = personaRepository.save(existingPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int id) {
        Optional<ModelPersona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            personaRepository.delete(persona.get());
            return ResponseEntity.ok("Persona deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
