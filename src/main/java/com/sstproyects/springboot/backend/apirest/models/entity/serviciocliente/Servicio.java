package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Servicios")
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idServicio",callSuper = false)
public class Servicio extends Auditable implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idServicio")
  @NotEmpty(message =" no puede estar vacio")
  private Long idServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "nombre_servicio", nullable = false)
  private String nombreServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "descripcion_servicio", nullable = false)
  private String descripcionServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "precio_servicio", nullable = false)
  private Double precioServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "laboratorio", nullable = false)
  private String laboratorio;

  @Column(name = "observaciones_servicio")
  private String observacionesServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "cod_servicio", nullable = false)
  private String codServicio;
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "cod_laboratorios")
  private String codLaboratorios;

  @Column(name = "descuento")
  private Double descuento;

  @Lob
  @Column(name = "foto")
  private byte[] foto;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  @Column(columnDefinition = "boolean default true") // Valor predeterminado establecido en "true" por defecto
  private boolean activo;
  private static final long serialVersionUID= 1L;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
}
