package com.joshuasantacruz.sportfinal.controller;

import com.joshuasantacruz.sportfinal.model.User;
import com.joshuasantacruz.sportfinal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Inyección de dependencias vía constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Crear usuario con validaciones del modelo
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        User saved = userService.savedUser(user);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario registrado correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todos
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Actualizar con validaciones
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        User updated = userService.updateUser(id, user);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
