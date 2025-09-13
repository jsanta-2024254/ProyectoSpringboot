package com.joshuasantacruz.RepuestosSA.controller;

import com.joshuasantacruz.RepuestosSA.model.Repuesto;
import com.joshuasantacruz.RepuestosSA.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    // Crear Repuesto
    @PostMapping
    public ResponseEntity<?> createRepuesto(@Valid @RequestBody Repuesto repuesto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Repuesto saved = repuestoService.saveRepuesto(repuesto);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Repuesto registrado correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todos
    @GetMapping
    public List<Repuesto> getAllRepuestos() {
        return repuestoService.getAllRepuestos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Repuesto getRepuestoById(@PathVariable Integer id) {
        return repuestoService.getRepuestoById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRepuesto(@PathVariable Integer id, @Valid @RequestBody Repuesto repuesto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Repuesto updated = repuestoService.updateRepuesto(id, repuesto);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteRepuesto(@PathVariable Integer id) {
        repuestoService.deleteRepuesto(id);
    }
}
