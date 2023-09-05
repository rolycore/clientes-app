package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cotizacion_cabe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class CotizacionCabe extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Long id;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "no_cotizacion", nullable = false)
  private String noCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "cliente_cotizacion", nullable = false)
  private String clienteCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "contacto_cotizacion", nullable = false)
  private String contactoCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "telefono_cotizacion", nullable = false)
  private String telefonoCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "correo_cotizacion", nullable = false)
  private String correoCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "celular_cotizacion", nullable = false)
  private String celularCotizacion;
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  @Column(name = "direccion_cotizacion", nullable = false)
  private String direccionCotizacion;

  @Column(name = "fecha_emitida_cotizacion", nullable = false)
  private String fechaEmitidaCotizacion;

  @Column(name = "fecha_vencimiento_cotizacion", nullable = false)
  private String fechaVencimientoCotizacion;

  @Column(name = "grantotal_cotizacion", nullable = false)
  private Double grantotalCotizacion;

  @Column(name = "itbms_cotizacion", nullable = false)
  private Double itbmsCotizacion;

  @Column(name = "valortotal_cotizacion", nullable = false)
  private Double valorTotalCotizacion;

  @Column(name = "aprobacion_cotizacion")
  private String aprobacionCotizacion;

  @Column(name = "estado_cotizacion")
  private String estadoCotizacion;

  @Column(name = "cod_solicitud")
  private String codSolicitud;

  @Column(name = "cod_cliente")
  private String codCliente;

  @Lob
  @Column(name = "observaciones_cotizacion")
  private String observacionesCotizacion;

  @Column(name = "fechaaprobacion")
  private String fechaAprobacion;
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
