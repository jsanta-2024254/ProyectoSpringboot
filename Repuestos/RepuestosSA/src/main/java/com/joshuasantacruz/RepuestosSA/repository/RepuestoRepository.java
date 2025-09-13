package com.joshuasantacruz.RepuestosSA.repository;

import com.joshuasantacruz.RepuestosSA.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
}
