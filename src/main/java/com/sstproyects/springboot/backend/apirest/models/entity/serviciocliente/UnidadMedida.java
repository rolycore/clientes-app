package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "unidades_medidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class UnidadMedida extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Long id;

  @Column(name = "abreviatura_um", nullable = false)
  private String abreviaturaUm;

  @Column(name = "descripcion_um", nullable = false)
  private String descripcionUm;

  @Column(name = "estado_um", nullable = false)
  private String estadoUm;

  @Lob
  @Column(name = "observaciones_um")
  private String observacionesUm;
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
