package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "estados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estado implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Integer id;

  @Column(name = "descripcion_estado", nullable = false)
  private String descripcionEstado;

  @Column(name = "cod_estado", nullable = false)
  private String codEstado;

  @Lob
  @Column(name = "observaciones_estados")
  private String observacionesEstados;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}
