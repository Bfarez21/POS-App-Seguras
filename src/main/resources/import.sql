-- 1. ROLES (sin dependencias)
INSERT INTO rol (id_rol, rol, estado) VALUES (1, 'ADMIN', true);
INSERT INTO rol (id_rol, rol, estado) VALUES (2, 'USER', true);

-- 2. PERSONAS (sin dependencias)
INSERT INTO persona (id_persona, nombre, apellido, dni, celular, correo) VALUES (1, 'Juan', 'Pérez', '1234567890', '0999999999', 'juan@example.com');

-- 3. TIPO PAGO (sin dependencias)
INSERT INTO tipo_pago (id_tipo_pago, tipo, descrip) VALUES (1, 'Efectivo', 'Pago en efectivo');

-- 4. CLASIFICACIONES (sin dependencias)
INSERT INTO clasificacion (id_clasificacion, grupo) VALUES (1, 'Tecnología');

-- 5. PROVEEDORES (sin dependencias)
INSERT INTO proveedores (id_proveedor, ruc, telefono, pais, correo, moneda) VALUES (1, '1799999999001', '022222222', 'Ecuador', 'proveedor@example.com', 'USD');

-- 6. PRODUCTOS (depende de clasificacion y proveedor)
INSERT INTO producto (id_producto, stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (1, 50, 150.00, 'unidad', 1, 1, true);
INSERT INTO producto (id_producto, stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (2, 30, 75.50, 'unidad', 1, 1, false);

-- 7. USUARIOS (depende de persona y rol)
INSERT INTO usuario (id_usuario, `user`, `password`, id_persona, id_rol) VALUES (1, 'admin', 'admin123', 1, 1);

-- 8. FACTURAS (depende de persona y tipo_pago)
INSERT INTO factura (id_factura, ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES (1, '1799999999001', 1, '2025-06-26', 1, 10.00, 290.00);

-- 9. ITEM FACTURA (depende de factura y producto)
INSERT INTO item_factura (id_item_factura, id_factura, id_producto, cantidad, precio, subtotal) VALUES (1, 1, 1, 1, 150.00, 150.00);
INSERT INTO item_factura (id_item_factura, id_factura, id_producto, cantidad, precio, subtotal) VALUES (2, 1, 2, 2, 75.50, 151.00);

-- 10. COMPETENCIAS (sin dependencias)
INSERT INTO competencia (id_competencias, nombre, descripcion) VALUES (1, 'Responsabilidad', 'Cumple con sus deberes.');
INSERT INTO competencia (id_competencias, nombre, descripcion) VALUES (2, 'Trabajo en equipo', 'Colabora con sus compañeros.');