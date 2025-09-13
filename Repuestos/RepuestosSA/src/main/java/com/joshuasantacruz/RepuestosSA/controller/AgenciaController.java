package com.joshuasantacruz.RepuestosSA.controller;

import com.joshuasantacruz.RepuestosSA.model.Agencia;
import com.joshuasantacruz.RepuestosSA.service.AgenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaController {

    private final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    // Crear Agencia
    @PostMapping
    public ResponseEntity<?> createAgencia(@Valid @RequestBody Agencia agencia, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Agencia saved = agenciaService.saveAgencia(agencia);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Agencia registrada correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todas
    @GetMapping
    public List<Agencia> getAllAgencias() {
        return agenciaService.getAllAgencias();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Agencia getAgenciaById(@PathVariable Integer id) {
        return agenciaService.getAgenciaById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAgencia(@PathVariable Integer id, @Valid @RequestBody Agencia agencia, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Agencia updated = agenciaService.updateAgencia(id, agencia);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteAgencia(@PathVariable Integer id) {
        agenciaService.deleteAgencia(id);
    }
}
