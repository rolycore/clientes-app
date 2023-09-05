package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;
@Entity(name = "Calibracion")
@Table(name = "calibracion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class Calibracion extends Auditable implements Serializable{

  @Id
  @Column(name = "id", nullable = false)
  @NotEmpty(message =" no puede estar vacio")
  private Long id;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "descripcion", nullable = false)
  private String descripcion;

  @Column(name = "cod_equipo", nullable = false,updatable = false)
  private String codigoEquipo;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "certificado", nullable = false)
  private String certificado;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "prox_calibracion", nullable = false)
  private String proximaCalibracion;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "calibrado_por", nullable = false)
  private String calibradoPor;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name="cod_cliente_calibracion", nullable = false,updatable=false)
  private String codCliente;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "nombre_cliente", nullable = false)
  private String nombreCliente;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  private static final long serialVersionUID= 1L;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
}
