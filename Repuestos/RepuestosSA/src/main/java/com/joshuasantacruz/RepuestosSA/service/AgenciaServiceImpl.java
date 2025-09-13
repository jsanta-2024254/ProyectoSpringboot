package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Agencia;
import com.joshuasantacruz.RepuestosSA.repository.AgenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public List<Agencia> getAllAgencias() {
        return agenciaRepository.findAll();
    }

    @Override
    public Agencia getAgenciaById(Integer id) {
        return agenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Agencia saveAgencia(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @Override
    public Agencia updateAgencia(Integer id, Agencia agencia) {
        Agencia existingAgencia = agenciaRepository.findById(id).orElse(null);
        if (existingAgencia != null) {
            existingAgencia.setNombreAgencia(agencia.getNombreAgencia());
            existingAgencia.setDireccionAgencia(agencia.getDireccionAgencia());
            existingAgencia.setTelefonoAgencia(agencia.getTelefonoAgencia());
            existingAgencia.setCorreoAgencia(agencia.getCorreoAgencia());
            return agenciaRepository.save(existingAgencia);
        }
        return null;
    }

    @Override
    public void deleteAgencia(Integer id) {
        agenciaRepository.deleteById(id);
    }
}
