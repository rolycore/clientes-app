CREATE TABLE cotizacion_detalle (
  cantidad_cotizacion_detalle int NOT NULL,
  costo_cotizacion_detalle double NOT NULL,
  create_at date DEFAULT NULL,
  descuento_cotizacion_detalle double NOT NULL,
  grantotal float DEFAULT NULL,
  impuesto float DEFAULT NULL,
  no_items_cotizacion_detalle int NOT NULL,
  total_cotizacion_detalle double NOT NULL,
  id bigint NOT NULL AUTO_INCREMENT,
  codigo_cotizacion_detalle varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  no_cotizacion varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  servicio_cotizacion_detalle varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci
