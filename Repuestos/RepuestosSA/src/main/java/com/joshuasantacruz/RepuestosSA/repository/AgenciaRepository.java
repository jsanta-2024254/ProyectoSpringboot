package com.joshuasantacruz.RepuestosSA.repository;

import com.joshuasantacruz.RepuestosSA.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
}