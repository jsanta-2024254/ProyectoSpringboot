package com.joshuasantacruz.RepuestosSA.repository;

import com.joshuasantacruz.RepuestosSA.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}