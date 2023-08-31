CREATE TABLE precios (
  create_at date DEFAULT NULL,
  precios double NOT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  cod_laboratorio_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  cod_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  cod_servicio_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  descripcion_servicio_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  metodo_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  nombre_lista_precios varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  nombre_servicio_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  norma_precios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  observaciones_precios varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  tipo_instrumento varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
