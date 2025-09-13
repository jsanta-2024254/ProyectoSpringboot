package com.joshuasantacruz.RepuestosSA.controller;

import com.joshuasantacruz.RepuestosSA.model.Proveedor;
import com.joshuasantacruz.RepuestosSA.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Crear Proveedor
    @PostMapping
    public ResponseEntity<?> createProveedor(@Valid @RequestBody Proveedor proveedor, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Proveedor saved = proveedorService.saveProveedor(proveedor);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Proveedor registrado correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todos
    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable Integer id) {
        return proveedorService.getProveedorById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable Integer id, @Valid @RequestBody Proveedor proveedor, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Proveedor updated = proveedorService.updateProveedor(id, proveedor);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Integer id) {
        proveedorService.deleteProveedor(id);
    }
}
