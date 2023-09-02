CREATE TABLE capacidad_medicion (
  create_at date DEFAULT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  especificaciones varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  fuente_traza varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  incertidumbre_maximo varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  incertidumbre_minimo varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  instrumento_calibrar varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  intervalo_maximo varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  intervalo_minimo varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  magnitud varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  mesurando varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  metodo_calibración varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  parametros varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  patron_ref varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  resolucion varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci
