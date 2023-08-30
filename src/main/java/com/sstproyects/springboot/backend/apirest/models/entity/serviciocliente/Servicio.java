package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Servicios")
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idservicio")
public class Servicio implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idservicio")
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
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
}
