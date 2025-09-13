package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(Integer id);
    Proveedor saveProveedor(Proveedor proveedor);
    Proveedor updateProveedor(Integer id, Proveedor proveedor);
    void deleteProveedor(Integer id);
}
