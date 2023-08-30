package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity(name="EquipoCliente")
@Table(name="equipocliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EquipoCliente implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id ;
  @NotEmpty(message =" no puede estar vacio")
  @NotBlank(message =" no puede estar vacio")
  @Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
  @Column(nullable=false)
  private String nombre;
  @NotEmpty(message =" no puede estar vacio")
  @NotBlank(message =" no puede estar vacio")
  @Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
  @Column(nullable=false)
  private String categoria_equipo;
  @Column
  private String capacidad_maxima ;
  @Column
  private String capacidad_minima ;
  @Column
  private String resolucion;
  @Column
  private String divisiones ;
  @Column
  private String observaciones ;
  @Column
  private String cod_cliente_equipo;
  @Lob
  @NotEmpty(message =" no puede estar vacio")
  @NotBlank(message =" no puede estar vacio")
  @Column(nullable=false)
  private byte[] imagen_equipo;
  @Column
  private String unidad_medida;
  @Column
  private String instrumento;
  @Column
  private String mide ;
  @Column(nullable=false)
  private String lista_precio;
  @Column
  private String cmc_equipo;
  @Column
  private String fabricante_receptor;
  @Column
  private String modelo_receptor ;
  @Column
  private String serie_receptor ;
  @Column
  private String id_interno_receptor ;
  @Column
  private String fabricante_sensor;
  @Column
  private String modelo_sensor ;
  @Column
  private String id_interno_sensor ;
  @Column
  private String serie_sensor;
  @Column
  private String fabricante_indicador ;
  @Column
  private String modelo_indicador;
  @Column
  private String serie_indicador;
  @Column
  private String id_interno_indicador;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }

}
