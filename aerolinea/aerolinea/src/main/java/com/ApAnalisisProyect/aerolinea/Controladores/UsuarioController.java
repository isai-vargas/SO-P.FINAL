package com.ApAnalisisProyect.aerolinea.Controladores;

import com.ApAnalisisProyect.aerolinea.Interfaces.InterfaceUsuario;
import com.ApAnalisisProyect.aerolinea.Modelo.ModelUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private InterfaceUsuario usuarioRepository;

    @GetMapping
    public List<ModelUsuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<ModelUsuario> getUsuarioById(@PathVariable int idUsuario) {
        Optional<ModelUsuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{nombreUsuario}/{contrasena}")
    public ResponseEntity<Integer> validarCredenciales(@PathVariable String nombreUsuario, @PathVariable String contrasena) {
        // Lógica para validar las credenciales
        Optional<ModelUsuario> usuario = usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(1); // Credenciales válidas
        } else {
            return ResponseEntity.ok(0); // Credenciales inválidas
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelUsuario> insertUsuario(@RequestBody ModelUsuario usuario) {
        ModelUsuario newUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<ModelUsuario> updateUsuario(@PathVariable int idUsuario, @RequestBody ModelUsuario usuario) {
        Optional<ModelUsuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            ModelUsuario existingUsuario = usuarioOptional.get();
            existingUsuario.setPersona(usuario.getPersona());
            existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existingUsuario.setContrasena(usuario.getContrasena());

            ModelUsuario updatedUsuario = usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable int idUsuario) {
        Optional<ModelUsuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok("Usuario eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
