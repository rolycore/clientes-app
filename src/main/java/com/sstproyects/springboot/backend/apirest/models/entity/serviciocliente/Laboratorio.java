package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;



import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Laboratorios")
@Table(name = "laboratorios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idLab",callSuper = false)
public class Laboratorio extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idLab")
  @NotBlank(message =" no puede estar vacio")
  private Integer idLab;
  @NotBlank(message =" no puede estar vacio")
  @Column(name = "cod_laboratorios", nullable = false)
  private String codLaboratorios;
  @NotBlank(message =" no puede estar vacio")
  @Column(name = "descripcion_laboratorios", nullable = false)
  private String descripcionLaboratorios;

  @Lob
  @Column(name = "observaciones_laboratorios")
  private String observacionesLaboratorios;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  @Column(columnDefinition = "boolean default true") // Valor predeterminado establecido en "true" por defecto
  private boolean activo;
  private static final long serialVersionUID= 1L;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}
