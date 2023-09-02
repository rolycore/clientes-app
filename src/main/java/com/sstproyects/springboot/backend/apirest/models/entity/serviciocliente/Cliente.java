package com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message =" no puede estar vacio")
	@NotBlank(message =" no puede estar vacio")
	@Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
	@Column(nullable=false)
	private String nombre;
	@NotEmpty(message =" no puede estar vacio")
	@NotBlank(message =" no puede estar vacio")
	@Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
	@Column(nullable=false)
	private String apellido;
	@NotEmpty(message =" no puede estar vacio")
	@NotBlank(message =" no puede estar vacio")
	@Email(message="no es una dirección bien formada")
	@Column(nullable=false, unique=true)
	private String email;
	@NotEmpty(message =" no puede estar vacio")
	@NotBlank(message =" no puede estar vacio")
	@Column(name="create_at",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createAt;
  @Column
  private String telefono_empresa;
  @Column(nullable=false, unique=true)
  @NotEmpty(message =" no puede estar vacio")
  @NotBlank(message =" no puede estar vacio")
  private String cod_cliente;
  @Column
  private String razon_social;
  @Column
  @NotBlank(message =" no puede estar vacio")
  private String nombre_comercial;
  @Column
  @NotBlank(message =" no puede estar vacio")
  private String  ruc;
  @Column
  @NotBlank(message =" no puede estar vacio")
  private String dv;
  @Column
  @NotBlank(message =" no puede estar vacio")
  private String direccion;
  @Column
  private String telefono_jefe;
  @Column
  private String celular_jefe;
  @Column
  private String correo_electronico;
  @Column
  private String actividad_economica;
  @Column
  private String abreviatura;
  @Column
  private String nombre_contacto;
  @Column
  private String cargo_servicio;
  @Column
  private String celular_servicio;
  @Column
  private String correo_servicio;
  @Column
  private String telefono_servicio;
  @Column
  private String nombre_cobro;
  @Column
  private String cargo_cobro;
  @Column
  private String telefono_cobro;
  @Column
  private String celular_cobro;
  @Column
  private String correo_cobro;
  private static final long serialVersionUID= 1L;
	@PrePersist
	public void prePersist() {
		createAt = new Date();


  }

}
