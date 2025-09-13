package com.joshuasantacruz.RepuestosSA.service;

import com.joshuasantacruz.RepuestosSA.model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Integer id);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Integer id, Cliente cliente);
    void deleteCliente(Integer id);
}
