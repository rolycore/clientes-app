package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoDao extends JpaRepository<Estado, Integer> {
}
