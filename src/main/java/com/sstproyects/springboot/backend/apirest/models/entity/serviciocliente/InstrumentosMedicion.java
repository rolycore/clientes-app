package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "instrumentos_medicion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class InstrumentosMedicion extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Long id;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "mide", nullable = false)
  private String mide;
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
