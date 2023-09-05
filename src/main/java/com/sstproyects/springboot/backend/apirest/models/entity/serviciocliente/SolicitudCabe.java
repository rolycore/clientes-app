package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import com.sstproyects.springboot.backend.apirest.auditoria.modelo.Auditable;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitud_cabe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id",callSuper = false)
public class SolicitudCabe extends Auditable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private Long id;

  @Column(name = "contacto_solicitud", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private String contactoSolicitud;

  @Column(name = "cliente_solicitud", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private String clienteSolicitud;

  @Column(name = "telefono_solicitud", nullable = false)
  private String telefonoSolicitud;

  @Column(name = "correo_solicitud", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private String correoSolicitud;

  @Column(name = "servicio_solicitud", nullable = false)
  @NotBlank(message =" no puede estar vacio")
  @NotEmpty(message =" no puede estar vacio")
  private String servicioSolicitud;

  @Column(name = "descripcion_solicitud", nullable = false)
  private String descripcionSolicitud;

  @Lob
  @Column(name = "archivo_adjunto")
  private byte[] archivoAdjunto;

  @Column(name = "observaciones_solicitud")
  private String observacionesSolicitud;

  @Column(name = "fechasolicitud", nullable = false)
  private String fechaSolicitud;

  @Column(name = "aprobacion_solicitud")
  private String aprobacionSolicitud;

  @Column(name = "cod_cliente", nullable = false)
  private String codCliente;

  @Column(name = "estado_solicitud", nullable = false)
  private String estadoSolicitud;

  @Column(name = "cod_solicitud", nullable = false)
  private String codSolicitud;

  @Lob
  @Column(name = "direccion_solicitud")
  private String direccionSolicitud;

  @Column(name = "grantotal")
  private Float grantotal;

  @Column(name = "impuesto")
  private Float impuesto;

  @Column(name = "total")
  private Float total;

  @Column(name = "celular_contacto")
  private String celularContacto;

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
