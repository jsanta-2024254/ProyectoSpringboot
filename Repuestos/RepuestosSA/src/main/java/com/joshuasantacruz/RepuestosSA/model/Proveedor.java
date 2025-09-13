package com.joshuasantacruz.RepuestosSA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_proveedor")
    private Integer codigoProveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(name = "nombre_proveedor", nullable = false, length = 100)
    private String nombreProveedor;

    @Size(max = 200, message = "La dirección no puede superar los 200 caracteres")
    @Column(name = "direccion_proveedor", length = 200)
    private String direccionProveedor;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{8,15}$",
            message = "El teléfono debe contener solo dígitos y tener entre 8 y 15 caracteres"
    )
    @Column(name = "telefono_proveedor", length = 20)
    private String telefonoProveedor;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%-]+@(gmail\\.com|yahoo\\.com|hotmail\\.com|outlook\\.com|kinal\\.edu.gt|kinal\\.org.gt)$",
            message = "El correo solo permite dominios: gmail, yahoo, hotmail, outlook, kinal.edu.gt, kinal.org.gt"
    )
    @Column(name = "correo_proveedor", length = 100)
    private String correoProveedor;

    // Relación con Repuestos
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repuesto> repuestos;

    // Getters y Setters
    public Integer getCodigoProveedor() { return codigoProveedor; }
    public void setCodigoProveedor(Integer codigoProveedor) { this.codigoProveedor = codigoProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public String getDireccionProveedor() { return direccionProveedor; }
    public void setDireccionProveedor(String direccionProveedor) { this.direccionProveedor = direccionProveedor; }

    public String getTelefonoProveedor() { return telefonoProveedor; }
    public void setTelefonoProveedor(String telefonoProveedor) { this.telefonoProveedor = telefonoProveedor; }

    public String getCorreoProveedor() { return correoProveedor; }
    public void setCorreoProveedor(String correoProveedor) { this.correoProveedor = correoProveedor; }

    public List<Repuesto> getRepuestos() { return repuestos; }
    public void setRepuestos(List<Repuesto> repuestos) { this.repuestos = repuestos; }
}
