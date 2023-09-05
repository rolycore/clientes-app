CREATE TABLE usuario (
  create_at date NOT NULL,
  estatus int NOT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  nombre varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  password varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  username varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_5171l57faosmj8myawaucatdw (email),
  UNIQUE KEY UK_cto7dkti4t38iq8r4cqesbd8k (nombre),
  UNIQUE KEY UK_863n1y3x0jalatoir4325ehal (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
