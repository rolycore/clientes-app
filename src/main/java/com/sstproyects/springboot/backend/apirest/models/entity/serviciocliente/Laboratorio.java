package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;



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
@EqualsAndHashCode(of = "id")
public class Laboratorio implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotBlank(message =" no puede estar vacio")
  private Integer id;
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
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}
