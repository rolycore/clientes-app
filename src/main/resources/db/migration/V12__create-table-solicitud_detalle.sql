CREATE TABLE solicitudes_detalle (
  cantidad_solicitudes_detalle int NOT NULL,
  costo_solicitud_detalle float NOT NULL,
  create_at date DEFAULT NULL,
  descuento_solicitud_detalle float DEFAULT NULL,
  grantotal float DEFAULT NULL,
  impuesto float DEFAULT NULL,
  total_solicitud_detalle float NOT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  cod_servicio varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  cod_solicitud varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  item_solicitudes_detalle varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  descripcion tinytext COLLATE utf8mb4_spanish2_ci,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
