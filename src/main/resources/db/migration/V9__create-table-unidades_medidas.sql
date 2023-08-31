CREATE TABLE unidades_medidas (
  create_at date DEFAULT NULL,
  id int NOT NULL AUTO_INCREMENT,
  abreviatura_um varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  descripcion_um varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  estado_um varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  observaciones_um text COLLATE utf8mb4_spanish_ci,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci COMMENT='tabla para las unidades de medidas, abreviaturas';
