package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnidadMedidaDao extends JpaRepository<UnidadMedida, Long> {
}
