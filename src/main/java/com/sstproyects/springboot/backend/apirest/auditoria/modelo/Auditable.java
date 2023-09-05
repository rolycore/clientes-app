package com.sstproyects.springboot.backend.apirest.auditoria.modelo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

  @CreatedBy
  protected String creadoPor;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date fechaHoraCreacion;

  @LastModifiedBy
  protected String ultimaActualizacionPor;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date fechaHoraUltimaActualizacion;
}
