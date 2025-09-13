DROP DATABASE IF EXISTS DB_RepuestosAutomotrices;
CREATE DATABASE DB_RepuestosAutomotrices;
USE DB_RepuestosAutomotrices;


-- ------------- Entidad Agencias -------------
CREATE TABLE Agencias (
    codigo_agencia INT AUTO_INCREMENT,
    nombre_agencia VARCHAR(100) NOT NULL,
    direccion_agencia VARCHAR(200),
    telefono_agencia VARCHAR(20),
    correo_agencia VARCHAR(100),
    PRIMARY KEY PK_codigo_agencia (codigo_agencia)
);

-- ------------- Entidad Proveedores -------------
CREATE TABLE Proveedores (
    codigo_proveedor INT AUTO_INCREMENT,
    nombre_proveedor VARCHAR(100) NOT NULL,
    direccion_proveedor VARCHAR(200),
    telefono_proveedor VARCHAR(20),
    correo_proveedor VARCHAR(100),
    PRIMARY KEY PK_codigo_proveedor(codigo_proveedor)
);

-- ------------- Entidad Clientes -------------
CREATE TABLE Clientes (
    codigo_cliente INT AUTO_INCREMENT,
    nombre_cliente VARCHAR(100) NOT NULL,
    apellido_cliente VARCHAR(100),
    direccion_cliente VARCHAR(200),
    telefono_cliente VARCHAR(20),
    correo_cliente VARCHAR(100),
    PRIMARY KEY PK_codigo_cliente (codigo_cliente)
);

-- ------------- Entidad Repuestos -------------
CREATE TABLE Repuestos (
    codigo_repuesto INT AUTO_INCREMENT,
    nombre_repuesto VARCHAR(100) NOT NULL,
    descripcion_repuesto VARCHAR(200),
    marca_repuesto VARCHAR(50),
    precio_repuesto DECIMAL(10,2),
    cantidad_repuesto INT,
    codigo_agencia INT NOT NULL,
    codigo_proveedor INT NOT NULL,
    PRIMARY KEY PK_codigo_repuesto (codigo_repuesto),
    CONSTRAINT FK_repuestosCodigoAgencia FOREIGN KEY (codigo_agencia)
        REFERENCES Agencias (codigo_agencia),
    CONSTRAINT FK_repuestosCodigoProveedor FOREIGN KEY (codigo_proveedor)
        REFERENCES Proveedores (codigo_proveedor)
);

select * from Agencias;