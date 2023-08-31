package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CapacidadMedicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICapacidadMedicionDao extends JpaRepository<CapacidadMedicion, Long> {
}
