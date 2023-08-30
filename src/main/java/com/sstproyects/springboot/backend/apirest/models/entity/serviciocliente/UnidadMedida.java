package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
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
@EqualsAndHashCode(of = "id")
public class UnidadMedida implements Serializable {

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
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}
