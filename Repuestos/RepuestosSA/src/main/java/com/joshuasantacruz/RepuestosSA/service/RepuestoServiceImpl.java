package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Repuesto;
import com.joshuasantacruz.RepuestosSA.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImpl(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAllRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(Integer id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Repuesto existingRepuesto = repuestoRepository.findById(id).orElse(null);
        if (existingRepuesto != null) {
            existingRepuesto.setNombreRepuesto(repuesto.getNombreRepuesto());
            existingRepuesto.setDescripcionRepuesto(repuesto.getDescripcionRepuesto());
            existingRepuesto.setMarcaRepuesto(repuesto.getMarcaRepuesto());
            existingRepuesto.setPrecioRepuesto(repuesto.getPrecioRepuesto());
            existingRepuesto.setCantidadRepuesto(repuesto.getCantidadRepuesto());
            existingRepuesto.setAgencia(repuesto.getAgencia());
            existingRepuesto.setProveedor(repuesto.getProveedor());
            return repuestoRepository.save(existingRepuesto);
        }
        return null;
    }

    @Override
    public void deleteRepuesto(Integer id) {
        repuestoRepository.deleteById(id);
    }
}
