package com.joshuasantacruz.RepuestosSA.model;

import com.joshuasantacruz.RepuestosSA.model.Repuesto;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "Agencias")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_agencia")
    private Integer codigoAgencia;

    @Column(name = "nombre_agencia", nullable = false, length = 100)
    private String nombreAgencia;

    @Column(name = "direccion_agencia", length = 200)
    private String direccionAgencia;

    @Column(name = "telefono_agencia", length = 20)
    private String telefonoAgencia;

    @Column(name = "correo_agencia", length = 100)
    private String correoAgencia;

    // Relación con Repuestos
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repuesto> repuestos;

    // Getters y Setters
    public Integer getCodigoAgencia() { return codigoAgencia; }
    public void setCodigoAgencia(Integer codigoAgencia) { this.codigoAgencia = codigoAgencia; }

    public String getNombreAgencia() { return nombreAgencia; }
    public void setNombreAgencia(String nombreAgencia) { this.nombreAgencia = nombreAgencia; }

    public String getDireccionAgencia() { return direccionAgencia; }
    public void setDireccionAgencia(String direccionAgencia) { this.direccionAgencia = direccionAgencia; }

    public String getTelefonoAgencia() { return telefonoAgencia; }
    public void setTelefonoAgencia(String telefonoAgencia) { this.telefonoAgencia = telefonoAgencia; }

    public String getCorreoAgencia() { return correoAgencia; }
    public void setCorreoAgencia(String correoAgencia) { this.correoAgencia = correoAgencia; }

    public List<Repuesto> getRepuestos() { return repuestos; }
    public void setRepuestos(List<Repuesto> repuestos) { this.repuestos = repuestos; }
}

