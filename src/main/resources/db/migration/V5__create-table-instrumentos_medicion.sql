CREATE TABLE instrumentos_medicion (
  create_at date DEFAULT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  mide varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  nombre varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
