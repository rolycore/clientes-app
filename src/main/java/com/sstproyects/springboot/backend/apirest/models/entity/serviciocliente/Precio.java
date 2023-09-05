package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;
import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "precios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class Precio extends Auditable implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nombre_servicio_precios", nullable = false)
  private String nombreServicioPrecios;

  @Column(name = "cod_servicio_precios", nullable = false)
  private String codServicioPrecios;

  @Column(name = "norma_precios", nullable = false)
  private String normaPrecios;

  @Column(name = "metodo_precios", nullable = false)
  private String metodoPrecios;

  @Column(name = "precios", nullable = false)
  private Double precios;

  @Column(name = "descripcion_servicio_precios", nullable = false)
  private String descripcionServicioPrecios;

  @Column(name = "observaciones_precios")
  private String observacionesPrecios;

  @Column(name = "cod_precios", nullable = false)
  private String codPrecios;

  @Column(name = "cod_laboratorio_precios", nullable = false)
  private String codLaboratorioPrecios;

  @Column(name = "tipo_instrumento")
  private String tipoInstrumento;

  @Column(name = "nombre_lista_precios")
  private String nombreListaPrecios;
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
