-- Implementa PostGis
CREATE EXTENSION postgis;

-- Tabla Producto
CREATE TABLE Product(
    ID INTEGER PRIMARY KEY,
    Codigo VARCHAR(100)
    Nombre VARCHAR(100)
    Fecha_vencimiento DATE
    Categoria VARCHAR(100)
    Precio INTEGER
);
