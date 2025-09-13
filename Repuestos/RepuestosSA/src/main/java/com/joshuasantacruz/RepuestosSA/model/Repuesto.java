package com.joshuasantacruz.RepuestosSA.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Repuestos")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_repuesto")
    private Integer codigoRepuesto;

    @Column(name = "nombre_repuesto", nullable = false, length = 100)
    private String nombreRepuesto;

    @Column(name = "descripcion_repuesto", length = 200)
    private String descripcionRepuesto;

    @Column(name = "marca_repuesto", length = 50)
    private String marcaRepuesto;

    @Column(name = "precio_repuesto", precision = 10, scale = 2)
    private BigDecimal precioRepuesto;  // <-- Cambio de Double a BigDecimal

    @Column(name = "cantidad_repuesto")
    private Integer cantidadRepuesto;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "codigo_agencia", nullable = false)
    private Agencia agencia;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor", nullable = false)
    private Proveedor proveedor;

    // Getters y Setters
    public Integer getCodigoRepuesto() { return codigoRepuesto; }
    public void setCodigoRepuesto(Integer codigoRepuesto) { this.codigoRepuesto = codigoRepuesto; }

    public String getNombreRepuesto() { return nombreRepuesto; }
    public void setNombreRepuesto(String nombreRepuesto) { this.nombreRepuesto = nombreRepuesto; }

    public String getDescripcionRepuesto() { return descripcionRepuesto; }
    public void setDescripcionRepuesto(String descripcionRepuesto) { this.descripcionRepuesto = descripcionRepuesto; }

    public String getMarcaRepuesto() { return marcaRepuesto; }
    public void setMarcaRepuesto(String marcaRepuesto) { this.marcaRepuesto = marcaRepuesto; }

    public BigDecimal getPrecioRepuesto() { return precioRepuesto; }
    public void setPrecioRepuesto(BigDecimal precioRepuesto) { this.precioRepuesto = precioRepuesto; }

    public Integer getCantidadRepuesto() { return cantidadRepuesto; }
    public void setCantidadRepuesto(Integer cantidadRepuesto) { this.cantidadRepuesto = cantidadRepuesto; }

    public Agencia getAgencia() { return agencia; }
    public void setAgencia(Agencia agencia) { this.agencia = agencia; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
}
