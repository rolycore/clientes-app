create table calibracion (
  create_at date DEFAULT NULL,
  id bigint NOT NULL,
  calibrado_por varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  certificado varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  cod_cliente varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  descripcion varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  nombre_cliente varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  prox_calibracion varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
