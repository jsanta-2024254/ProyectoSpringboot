package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Cliente;
import com.joshuasantacruz.RepuestosSA.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNombreCliente(cliente.getNombreCliente());
            existingCliente.setApellidoCliente(cliente.getApellidoCliente());
            existingCliente.setDireccionCliente(cliente.getDireccionCliente());
            existingCliente.setTelefonoCliente(cliente.getTelefonoCliente());
            existingCliente.setCorreoCliente(cliente.getCorreoCliente());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
