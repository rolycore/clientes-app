CREATE TABLE servicios (
  create_at date DEFAULT NULL,
  descuento double DEFAULT NULL,
  precio_servicio double NOT NULL,
  idservicio bigint NOT NULL AUTO_INCREMENT,
  cod_laboratorios varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  cod_servicio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  descripcion_servicio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  laboratorio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  nombre_servicio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  observaciones_servicio varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  foto tinyblob,
  PRIMARY KEY (idservicio)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
