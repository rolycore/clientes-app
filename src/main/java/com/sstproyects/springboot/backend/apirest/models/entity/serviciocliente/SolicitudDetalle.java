package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitudes_detalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDetalle extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Long id;

  @Column(name = "item_solicitudes_detalle", nullable = false)
  private String itemSolicitudesDetalle;

  @Column(name = "cod_servicio", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private String codServicio;

  @Column(name = "cantidad_solicitudes_detalle", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Integer cantidadSolicitudesDetalle;

  @Column(name = "costo_solicitud_detalle", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Float costoSolicitudDetalle;

  @Column(name = "descuento_solicitud_detalle")
  private Float descuentoSolicitudDetalle;

  @Column(name = "total_solicitud_detalle", nullable = false)
  private Float totalSolicitudDetalle;

  @Column(name = "cod_solicitud", nullable = false)
  private String codSolicitud;

  @Column(name = "impuesto")
  private Float impuesto;

  @Column(name = "grantotal")
  private Float grantotal;

  @Lob
  @Column(name = "descripcion")
  private String descripcion;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  private static final long serialVersionUID= 1L;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}

