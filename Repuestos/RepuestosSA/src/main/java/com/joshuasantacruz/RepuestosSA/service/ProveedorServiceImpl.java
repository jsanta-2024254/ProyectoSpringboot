package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Proveedor;
import com.joshuasantacruz.RepuestosSA.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer id, Proveedor proveedor) {
        Proveedor existingProveedor = proveedorRepository.findById(id).orElse(null);
        if (existingProveedor != null) {
            existingProveedor.setNombreProveedor(proveedor.getNombreProveedor());
            existingProveedor.setDireccionProveedor(proveedor.getDireccionProveedor());
            existingProveedor.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            existingProveedor.setCorreoProveedor(proveedor.getCorreoProveedor());
            return proveedorRepository.save(existingProveedor);
        }
        return null;
    }

    @Override
    public void deleteProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
