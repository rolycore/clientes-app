package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Calibracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalibracionDao extends JpaRepository<Calibracion, Long> {
}
