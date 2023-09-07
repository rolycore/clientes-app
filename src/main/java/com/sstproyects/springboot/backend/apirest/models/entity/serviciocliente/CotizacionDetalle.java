package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cotizacion_detalle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionDetalle extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCotdetalle;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "no_cotizacion", nullable = false)
  private String noCotizacion;

  @Column(name = "no_items_cotizacion_detalle", nullable = false)
  private Integer noItemsCotizacionDetalle;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "codigo_cotizacion_detalle", nullable = false)
  private String codigoCotizacionDetalle;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "servicio_cotizacion_detalle", nullable = false)
  private String servicioCotizacionDetalle;

  @Column(name = "cantidad_cotizacion_detalle", nullable = false)
  private Integer cantidadCotizacionDetalle;

  @Column(name = "costo_cotizacion_detalle", nullable = false)
  private Double costoCotizacionDetalle;

  @Column(name = "descuento_cotizacion_detalle", nullable = false)
  private Double descuentoCotizacionDetalle;

  @Column(name = "total_cotizacion_detalle", nullable = false)
  private Double totalCotizacionDetalle;

  @Column(name = "impuesto")
  private Float impuesto;

  @Column(name = "grantotal")
  private Float grantotal;
  @Temporal(TemporalType.DATE)
  private Date createAt;
  private static final long serialVersionUID= 1L;
  @ManyToOne(fetch = FetchType.LAZY, optional=false)
  @JoinColumn(name = "idEquipo")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private EquipoCliente equipo;
  @ManyToOne(fetch = FetchType.LAZY, optional=false)
  @JoinColumn(name = "idCotizacion")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private CotizacionCabe cotizacion;


  @PrePersist
  public void prePersist() {
    createAt = new Date();

  }
  // Otros métodos, constructores, getters y setters según sea necesario
}
