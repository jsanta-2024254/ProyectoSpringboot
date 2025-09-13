package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Repuesto;
import java.util.List;

public interface RepuestoService {
    List<Repuesto> getAllRepuestos();
    Repuesto getRepuestoById(Integer id);
    Repuesto saveRepuesto(Repuesto repuesto);
    Repuesto updateRepuesto(Integer id, Repuesto repuesto);
    void deleteRepuesto(Integer id);
}
