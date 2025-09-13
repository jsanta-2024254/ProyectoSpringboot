package com.joshuasantacruz.RepuestosSA.controller;

import com.joshuasantacruz.RepuestosSA.model.Cliente;
import com.joshuasantacruz.RepuestosSA.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Crear Cliente
    @PostMapping
    public ResponseEntity<?> createCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Cliente saved = clienteService.saveCliente(cliente);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Cliente registrado correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todos
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Integer id, @Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Cliente updated = clienteService.updateCliente(id, cliente);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
    }
}
