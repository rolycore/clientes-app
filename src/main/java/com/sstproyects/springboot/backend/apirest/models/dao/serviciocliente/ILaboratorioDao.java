package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaboratorioDao extends JpaRepository<Laboratorio, Long> {
}
