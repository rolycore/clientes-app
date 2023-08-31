CREATE TABLE laboratorios (
  create_at date DEFAULT NULL,
  id int NOT NULL AUTO_INCREMENT,
  cod_laboratorios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  descripcion_laboratorios varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  observaciones_laboratorios tinytext COLLATE utf8mb4_spanish2_ci,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
