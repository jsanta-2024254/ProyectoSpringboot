package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Agencia;
import java.util.List;

public interface AgenciaService {
    List<Agencia> getAllAgencias();
    Agencia getAgenciaById(Integer id);
    Agencia saveAgencia(Agencia agencia);
    Agencia updateAgencia(Integer id, Agencia agencia);
    void deleteAgencia(Integer id);
}
