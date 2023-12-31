CREATE TABLE equipocliente (
  create_at date DEFAULT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  capacidad_maxima varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  capacidad_minima varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  categoria_equipo varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  cmc_equipo varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  cod_cliente_equipo varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  divisiones varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  fabricante_indicador varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  fabricante_receptor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  fabricante_sensor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  id_interno_indicador varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  id_interno_receptor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  id_interno_sensor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  instrumento varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  lista_precio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  mide varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  modelo_indicador varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  modelo_receptor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  modelo_sensor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  nombre varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  observaciones varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  resolucion varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  serie_indicador varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  serie_receptor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  serie_sensor varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  unidad_medida varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  imagen_equipo tinyblob NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
