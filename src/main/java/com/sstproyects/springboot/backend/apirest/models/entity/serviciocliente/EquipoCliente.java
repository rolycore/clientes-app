package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="equipocliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class EquipoCliente extends Auditable implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id ;
  @ColumnTransformer(
    read = "substring(codigoequipo, 5)", // Para leer desde la base de datos sin el prefijo
    write = "concat('CCE_', ?)" // Para escribir en la base de datos con el prefijo
  )
  @Column(updatable = false,nullable=false)
  private String codigoequipo;
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
  @NotEmpty(message =" no puede estar vacio")
  @NotBlank(message =" no puede estar vacio")
  @Column(name="cod_cliente_equipo",updatable=false)
  private String codClienteEquipo;
 // @ManyToOne
  //@JoinColumn(name = "cod_cliente_equipo", referencedColumnName = "cod_cliente")
 // private Cliente cliente;
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
  @Column(columnDefinition = "boolean default true") // Valor predeterminado establecido en "true" por defecto
  private boolean activo;
  private static final long serialVersionUID= 1L;

  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }

}
