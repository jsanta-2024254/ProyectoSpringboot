package com.joshuasantacruz.RepuestosSA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar los 100 caracteres")
    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombreCliente;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100, message = "El apellido no debe superar los 100 caracteres")
    @Column(name = "apellido_cliente", length = 100)
    private String apellidoCliente;

    @Size(max = 200, message = "La dirección no debe superar los 200 caracteres")
    @Column(name = "direccion_cliente", length = 200)
    private String direccionCliente;

    // Solo números, entre 8 y 15 dígitos
    @Pattern(regexp = "^[0-9]{8,15}$", message = "El teléfono debe contener entre 8 y 15 dígitos numéricos")
    @Column(name = "telefono_cliente", length = 20)
    private String telefonoCliente;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%-]+@(gmail\\.com|yahoo\\.com|hotmail\\.com|kinal\\.edu\\.gt|kinal\\.org\\.gt)$",
            message = "El correo solo permite dominios: gmail, yahoo, hotmail, kinal.edu.gt, kinal.org.gt"
    )
    @Column(name = "correo_cliente", length = 100)
    private String correoCliente;

    // Getters y Setters
    public Integer getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(Integer codigoCliente) { this.codigoCliente = codigoCliente; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getApellidoCliente() { return apellidoCliente; }
    public void setApellidoCliente(String apellidoCliente) { this.apellidoCliente = apellidoCliente; }

    public String getDireccionCliente() { return direccionCliente; }
    public void setDireccionCliente(String direccionCliente) { this.direccionCliente = direccionCliente; }

    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

    public String getCorreoCliente() { return correoCliente; }
    public void setCorreoCliente(String correoCliente) { this.correoCliente = correoCliente; }
}
