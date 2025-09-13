package com.joshuasantacruz.RepuestosSA.repository;

import com.joshuasantacruz.RepuestosSA.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
