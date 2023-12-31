package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "capacidad_medicion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idCap",callSuper = false)
public class CapacidadMedicion extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idCap")
  private Long idCap;

  @Column(name = "Instrumento_calibrar", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  private String instrumentoCalibrar;

  @Column(name = "magnitud", nullable = false)
  private String magnitud;

  @Column(name = "mesurando", nullable = false)
  private String mesurando;

  @Column(name = "metodo_calibración", nullable = false)
  private String metodoCalibracion;

  @Column(name = "patron_ref", nullable = false)
  private String patronRef;

  @Column(name = "fuente_traza", nullable = false)
  private String fuenteTraza;

  @Column(name = "intervalo_minimo", nullable = false)
  private String intervaloMinimo;

  @Column(name = "intervalo_maximo", nullable = false)
  private String intervaloMaximo;

  @Column(name = "resolucion", nullable = false)
  private String resolucion;

  @Column(name = "incertidumbre_minimo", nullable = false)
  private String incertidumbreMinimo;

  @Column(name = "incertidumbre_maximo", nullable = false)
  private String incertidumbreMaximo;

  @Column(name = "parametros", nullable = false)
  private String parametros;

  @Column(name = "especificaciones", nullable = false)
  private String especificaciones;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  private static final long serialVersionUID= 1L;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
}
