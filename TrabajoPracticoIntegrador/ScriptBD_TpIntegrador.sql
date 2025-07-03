create schema TPIntegrador;

use TPIntegrador;

create table TipoUsuarios(
IdTipoUsuario char(1) not null,
Descripcion varchar(25) not null,
constraint PK_TipoUsuarios primary key (IdTipoUsuario)
);

create table Usuarios(
IdUsuario int not null auto_increment,
IdTipoUsuario char(1) not null,
NombreUsuario varchar(50) not null,
Contrasena varchar(30) not null,
Estado bool default 1 not null,
constraint PK_Usuarios primary key (IdUsuario),
constraint FK_Usuarios_TipoUsuarios foreign key (IdTipoUsuario) references TipoUsuarios (IdTipoUsuario),
constraint unique_Usuarios unique (NombreUsuario)
);

create table Nacionalidades(
IdNacionalidad int not null auto_increment,
Descripcion varchar(50) not null,
constraint PK_Nacionalidades primary key(IdNacionalidad)
);

create table Provincias(
IdProvincia int not null auto_increment,
Descripcion varchar(50) not null,
constraint PK_Provincias primary key(IdProvincia)
);

create table Localidades(
IdLocalidad int not null auto_increment,
IdProvincia int not null,
Descripcion varchar(50) not null,
constraint PK_Localidades primary key(IdLocalidad),
constraint FK_Localidades_Provincias foreign key(IdProvincia) references Provincias (IdProvincia)
);

create table Clientes(
CodCliente int not null auto_increment,
IdUsuario int not null,
IdNacionalidad int not null,
IdProvincia int not null,
IdLocalidad int not null,
DNI char(8) not null,
CUIL char(11) not null,
Nombre varchar(40) not null,
Apellido varchar(40) not null,
Sexo char(1) not null,
Direccion varchar(70) not null,
FechaNacimiento date not null,
FechaDadoAlta datetime not null default CURRENT_TIMESTAMP,
Telefono varchar(25) not null,
CorreoElectronico varchar(40) not null,
Estado bool default 1 not null,
constraint PK_Clientes primary key (CodCliente),
constraint PK_Clientes_Usuarios foreign key (IdUsuario) references Usuarios (IdUsuario),
constraint PK_Clientes_Nacionalidad foreign key (IdNacionalidad) references Nacionalidades (IdNacionalidad),
constraint PK_Clientes_Provincias foreign key (IdProvincia) references Provincias (IdProvincia),
constraint PK_Clientes_Localidades foreign key (IdLocalidad) references Localidades (IdLocalidad),
constraint unique_Clientes unique (DNI)
);

create table TipoCuentas(
CodTipoCuenta char(1) not null,
Descripcion varchar(50) not null,
constraint PK_TipoCuentas primary key (CodTipoCuenta)
);

create table TipoMovimientos(
CodTipoMovimiento char(2) not null,
Descripcion varchar(50) not null,
constraint PK_TipoMovimientos primary key (CodTipoMovimiento)
);

create table Cuentas(
NroCuenta int auto_increment not null,
CodTipoCuenta char(1) not null,
CodCliente int not null,
CBU char(22) not null,
Saldo decimal(12,2) not null default 10000,
Fecha_alta datetime not null default CURRENT_TIMESTAMP,
Estado bool not null default 1,
constraint PK_Cuentas primary key (NroCuenta),
constraint FK_Cuentas_TipoCuentas foreign key (CodTipoCuenta) references TipoCuentas (CodTipoCuenta),
constraint FK_Cuentas_Clientes foreign key (CodCliente) references Clientes (CodCliente)
);

create table Movimientos(
CodMovimiento int auto_increment not null,
CodTipoMovimiento char(2) not null,
NroCuentaAsociado int not null,
Fecha datetime default CURRENT_TIMESTAMP,
Detalle varchar(100) not null default 'Sin detalles.',
Importe decimal(12,2) not null default 0.00,
constraint PK_Movimientos primary key (CodMovimiento),
constraint FK_Movimientos_TipoMovimientos foreign key (CodTipoMovimiento) references TipoMovimientos (CodTipoMovimiento),
constraint FK_Movimientos_Cuentas foreign key (NroCuentaAsociado) references Cuentas (NroCuenta)
);

create table Prestamos(
CodPrestamo int auto_increment not null,
CodCliente int not null,
NroCuentaAsociado int not null,
Fecha datetime default CURRENT_TIMESTAMP,
ImportePagar decimal(12,2) not null default 0.00,
ImportePedido decimal(12,2) not null default 0.00,
PlazoMeses int not null,
PagoMensual decimal(12,2) not null default 0.00,
CuotasTotales int not null,
-- 0 = Saldado | 1 = Vigente
Deuda bool not null default 1,
-- 0 = Rechazo/Aun sin aceptar | 1 = Aceptado
Estado bool not null default 0,
constraint PK_Prestamos primary key (CodPrestamo),
constraint FK_Prestamos_Clientes foreign key (CodCliente) references Clientes (CodCliente),
constraint FK_Prestamos_Cuentas foreign key (NroCuentaAsociado) references Cuentas (NroCuenta)
);

CREATE TABLE Cuotas (
    CodCuota int auto_increment not null,
    CodPrestamo int not null,
    NumeroCuota int not null,
    MontoCuota decimal(12,2) not null,
    FechaPago datetime null, 
    EstadoPago bool not null default 0,         
    
    constraint PK_Cuotas primary key (CodCuota),
    constraint FK_Cuotas_Prestamos foreign key (CodPrestamo) references Prestamos (CodPrestamo),
        CONSTRAINT CHK_Cuotas CHECK (NumeroCuota > 0 AND MontoCuota > 0)
);

-- Carga de registros

insert into TipoUsuarios values 
    ('C', 'Cliente'),
    ('A', 'Administrador');
    
insert into Usuarios (IdTipoUsuario, NombreUsuario, Contrasena, Estado) values
    ('C', 'juanp', 'clave123', 1),
    ('C', 'martal', 'pass456', 1),
    ('C', 'carlog', 'secreta', 1),
    ('C', 'lucianaa', 'miClave2024', 1),
    ('C', 'federicom', 'contraseña1', 1),
    ('C', 'rociog', 'rociopass', 1),
    ('C', 'ezequielz', 'eze45678', 1),
    ('C', 'sofiav', 'vivaSOFI', 1),
    ('C', 'agustinl', 'passagu123', 1),
    ('C', 'florenciad', 'flo1234', 1),
    ('C', 'daniels', 'danielpass', 1),
    ('C', 'paulac', 'paula321', 1),
    ('C', 'maxib', 'clavemaxi', 1),
    ('C', 'natalial', 'nataPASS', 1),
    ('C', 'sebastiant', 'seb7890', 1),
    ('A', 'admin', 'admin', 1),
    ('A', 'admin1', 'claveAdmin1', 1),
	('A', 'lucasadm', 'passLucas', 1),
	('A', 'marianadm', 'm@rian123', 1),
	('A', 'sofiaadmin', 'sof2025pwd', 1);
  
insert into Nacionalidades (Descripcion) values 
    ('Argentina'),
    ('Brasil'),
    ('Chile'),
    ('Uruguay'),
    ('Paraguay'),
    ('Bolivia'),
    ('Perú'),
    ('Colombia'),
    ('Venezuela'),
    ('México'),
    ('España'),
    ('Italia'),
    ('Alemania'),
    ('Francia'),
    ('Estados Unidos');

insert into Provincias (Descripcion) values 
    ('Buenos Aires'),
    ('Córdoba'),
    ('Mendoza'),
    ('Santa Fe'),
    ('Salta'),
    ('Tucumán'),
    ('Neuquén'),
    ('Chubut'),
    ('Misiones'),
    ('Corrientes'),
    ('Entre Ríos'),
    ('La Pampa'),
    ('San Juan'),
    ('San Luis'),
    ('Río Negro');

insert into Localidades (IdProvincia, Descripcion) values 
	(1, 'La Plata'),
	(1, 'Mar del Plata'),
	(1, 'Bahía Blanca'),
	(1, 'Tigre'),
	(1, 'San Isidro'),

	-- Córdoba (2)
    (2, 'Villa Carlos Paz'),
	(2, 'Córdoba Capital'),
	(2, 'Río Cuarto'),
	(2, 'Alta Gracia'),
	(2, 'Jesús María'),

	-- Mendoza (3)
    (3, 'Godoy Cruz'),
	(3, 'San Rafael'),
	(3, 'Luján de Cuyo'),
	(3, 'Maipú'),
	(3, 'Tunuyán'),

	-- Santa Fe (4)
    (4, 'Rosario'),
	(4, 'Santa Fe Capital'),
	(4, 'Rafaela'),
	(4, 'Venado Tuerto'),
	(4, 'Villa Gobernador Gálvez'),

	-- Salta (5)
    (5, 'Salta Capital'),
	(5, 'Cafayate'),
	(5, 'Orán'),
	(5, 'Tartagal'),
	(5, 'General Güemes'),

	-- Tucumán (6)
    (6, 'San Miguel de Tucumán'),
	(6, 'Yerba Buena'),
	(6, 'Tafí Viejo'),
	(6, 'Famaillá'),
	(6, 'Concepción'),

	-- Neuquén (7)
    (7, 'Neuquén Capital'),
	(7, 'Cutral Có'),
	(7, 'Plottier'),
	(7, 'Zapala'),
	(7, 'Centenario'),

	-- Chubut (8)
    (8, 'Comodoro Rivadavia'),
	(8, 'Puerto Madryn'),
	(8, 'Trelew'),
	(8, 'Esquel'),
	(8, 'Rawson'),

	-- Misiones (9)
    (9, 'Posadas'),
	(9, 'Eldorado'),
	(9, 'Oberá'),
	(9, 'Puerto Iguazú'),
	(9, 'Apóstoles'),

	-- Corrientes (10)
    (10, 'Corrientes Capital'),
	(10, 'Goya'),
	(10, 'Paso de los Libres'),
	(10, 'Bella Vista'),
	(10, 'Mercedes'),

	-- Entre Ríos (11)
    (11, 'Paraná'),
	(11, 'Concordia'),
	(11, 'Gualeguaychú'),
	(11, 'Concepción del Uruguay'),
	(11, 'Villaguay'),

	-- La Pampa (12)
    (12, 'Santa Rosa'),
	(12, 'General Pico'),
	(12, 'Toay'),
	(12, 'General Acha'),
	(12, 'Intendente Alvear'),

	-- San Juan (13)
    (13, 'San Juan Capital'),
	(13, 'Rawson'),
	(13, 'Chimbas'),
	(13, 'Pocito'),
	(13, 'Santa Lucía'),

	-- San Luis (14)
    (14, 'Villa Mercedes'),
	(14, 'San Luis Capital'),
	(14, 'La Punta'),
	(14, 'Villa de Merlo'),
	(14, 'Justo Daract'),

	-- Río Negro (15)
	(15, 'Viedma'),
	(15, 'General Roca'),
	(15, 'Cipolletti'),
	(15, 'Villa Regina'),
    (15, 'Bariloche');
    		
insert into Clientes (IdUsuario,IdNacionalidad,IdProvincia,IdLocalidad,DNI,CUIL,Nombre,Apellido,Sexo,Direccion,FechaNacimiento,Telefono,CorreoElectronico,Estado) values 
	(1, 1, 1, 1, '12345678', '20123456789', 'Juan', 'Pérez', 'M', 'Calle Falsa 123', '1990-05-10', '1155555555', 'juanp@email.com', 1),
	(2, 2, 2, 2, '87654321', '20234567890', 'Marta', 'López', 'F', 'Av. Central 456', '1985-08-22', '1166666666', 'martal@email.com', 1),
	(3, 3, 3, 3, '45678901', '20345678901', 'Carla', 'González', 'F', 'Mitre 789', '1992-12-01', '1177777777', 'carla@email.com', 1),
	(4, 4, 4, 4, '23456789', '20456789012', 'Luciana', 'Fernández', 'F', 'Calle 1 N°100', '1994-07-15', '1188888888', 'luciana@email.com', 1),
	(5, 5, 5, 5, '34567890', '20567890123', 'Federico', 'Martínez', 'M', 'Pasaje Sur 150', '1989-03-30', '1199999999', 'federico@email.com', 1),
	(6, 6, 6, 6, '56789012', '20678901234', 'Rocío', 'Ramírez', 'F', 'Diagonal 200', '1991-10-25', '1144444444', 'rocio@email.com', 1),
	(7, 7, 7, 7, '67890123', '20789012345', 'Ezequiel', 'Torres', 'M', 'Calle Norte 777', '1993-06-18', '1133333333', 'ezequiel@email.com', 1),
	(8, 8, 8, 8, '78901234', '20890123456', 'Sofía', 'Moreno', 'F', 'Ruta 8 km 15', '1988-01-09', '1122222222', 'sofia@email.com', 1),
	(9, 9, 9, 9, '89012345', '20901234567', 'Agustín', 'Silva', 'M', 'San Martín 250', '1995-09-12', '1111111111', 'agustin@email.com', 1),
	(10, 10, 10, 10, '90123456', '20123456780', 'Florencia', 'Suárez', 'F', 'Corrientes 333', '1997-11-27', '1100000000', 'florencia@email.com', 1),
	(11, 11, 11, 11, '11223344', '21122334455', 'Daniel', 'Mendoza', 'M', 'Belgrano 432', '1983-02-14', '1191234567', 'daniel@email.com', 1),
	(12, 12, 12, 12, '22334455', '22233445566', 'Paula', 'Gómez', 'F', 'Alsina 900', '1986-04-05', '1197654321', 'paula@email.com', 1),
	(13, 13, 13, 13, '33445566', '23344556677', 'Maximiliano', 'Ortiz', 'M', 'España 3200', '1990-08-08', '1183334444', 'maxi@email.com', 1),
	(14, 14, 14, 14, '44556677', '24455667788', 'Natalia', 'Cabrera', 'F', 'Italia 99', '1992-12-24', '1174445555', 'natalia@email.com', 1),
	(15, 15, 15, 15, '55667788', '25566778899', 'Sebastián', 'Domínguez', 'M', 'Urquiza 1550', '1991-07-01', '1165556666', 'sebastian@email.com', 1);

insert into tipocuentas (CodTipoCuenta, Descripcion) values
	('A', 'Caja de Ahorro'),
    ('C', 'Cuenta Corriente');
    
insert into tipomovimientos (CodTipoMovimiento, Descripcion) values
	('AC', 'Alta de cuenta'),
    ('AP', 'Alta de un Préstamo'),
    ('PP', 'Pago de Préstamo'),
    ('TT', 'Transferencia');
    
insert into cuentas (CodTipoCuenta, CodCliente, CBU, Saldo, Fecha_alta, Estado) values
	('A', 1, '0170042440000032598715', 10000.00, '2024-11-15 10:35:21', 1),
    ('C', 2, '0070003000000215789647', 50500.00, '2025-06-20 18:02:49', 1),
    ('A', 3, '2850441100000098765412', 7500.00, '2024-03-10 09:15:00', 1),
    ('C', 4, '0170056780000043217890', 13000.50, '2023-12-05 14:20:10', 1),
    ('A', 5, '0720061100000023456789', 32500.00, '2025-01-17 08:45:55', 1),
    ('C', 6, '0720074200000067891234', 5800.00, '2024-05-01 12:00:00', 1),
    ('A', 7, '0720083100000011122233', 41000.75, '2023-11-11 11:11:11', 1),
    ('A', 8, '0720092200000033001100', 9200.00, '2024-06-10 17:30:45', 1),
    ('C', 9, '0720104300000099998888', 27300.00, '2025-02-28 10:10:10', 1),
    ('C',10, '0720115400000044455566', 12000.25, '2025-06-01 09:00:00', 1),
    ('A',11, '0720126500000077776666', 15500.00, '2024-08-21 15:45:30', 1),
    ('C',12, '0720137600000012345678', 18880.00, '2024-10-30 16:25:00', 1),
    ('A',13, '0720148700000088887777', 6700.00, '2023-09-12 13:05:55', 1),
    ('C',14, '0720159800000022221111', 24400.99, '2025-03-18 08:20:45', 1),
    ('A',15, '0720160900000033332222', 9900.00, '2025-06-21 07:50:00', 1);
    
insert into movimientos (CodTipoMovimiento, NroCuentaAsociado, Fecha, Detalle, Importe) values
	('AC', 1, '2024-11-15 10:35:21', 'Alta de cuenta', 10000.00),
	('AC', 2, '2025-06-20 18:02:49', 'Alta de cuenta', 50500.00),
	('AP', 3, '2024-03-10 10:00:00', 'Préstamo personal acreditado', 15000.00),
	('PP', 3, '2024-04-10 10:00:00', 'Pago parcial del préstamo', -5000.00),
	('TT', 4, '2024-06-02 14:00:00', 'Transferencia a cuenta 7', -2500.00),
	('TT', 7, '2024-06-02 14:00:05', 'Transferencia recibida de cuenta 4', 2500.00),
	('PP', 5, '2025-02-01 09:30:00', 'Pago cuota préstamo', -4000.00),
	('AP', 6, '2024-05-01 13:00:00', 'Crédito aprobado', 8000.00),
	('TT', 6, '2024-07-01 11:11:00', 'Transferencia a cuenta 2', -2000.00),
	('TT', 2, '2024-07-01 11:11:03', 'Transferencia recibida de cuenta 6', 2000.00),
	('AC', 8, '2024-06-10 17:30:45', 'Alta de cuenta', 9200.00),
	('TT', 8, '2025-01-01 09:00:00', 'Transferencia a cuenta 10', -1500.00),
	('TT', 10, '2025-01-01 09:00:05', 'Transferencia recibida de cuenta 8', 1500.00),
	('PP', 11, '2025-03-03 12:00:00', 'Pago préstamo final', -6000.00),
	('AP', 12, '2024-10-30 17:00:00', 'Acreditación préstamo para viaje', 12000.00);

insert into prestamos (CodCliente, NroCuentaAsociado, Fecha, ImportePagar, ImportePedido, PlazoMeses, PagoMensual, CuotasTotales, Deuda, Estado) values
	(1, 1, '2024-11-15 11:00:00', 12000.00, 10000.00, 12, 1000.00, 12, 1, 1),
	(2, 2, '2025-06-20 18:10:00', 60000.00, 50000.00, 12, 5000.00, 12, 1, 1),
	(3, 3, '2024-03-10 10:00:00', 18000.00, 15000.00, 12, 1500.00, 12, 1, 1),
	(4, 4, '2024-01-05 14:20:10', 14400.00, 12000.00, 12, 1200.00, 12, 1, 1),
	(5, 5, '2023-12-15 09:00:00', 21600.00, 18000.00, 12, 1800.00, 12, 0, 1),
	(6, 6, '2024-05-01 13:00:00', 9600.00, 8000.00, 6, 1600.00, 6, 1, 1),
	(7, 7, '2024-06-02 10:30:00', 32400.00, 27000.00, 18, 1800.00, 18, 1, 1),
	(8, 8, '2024-08-01 12:00:00', 36000.00, 30000.00, 12, 3000.00, 12, 1, 1);
    
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 1, n, 1000.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;


INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 2, n, 5000.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;

-- Cuotas para Préstamo 3 (12 cuotas de 1500.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 3, n, 1500.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;

-- Cuotas para Préstamo 4 (12 cuotas de 1200.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 4, n, 1200.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;

-- Cuotas para Préstamo 5 (12 cuotas de 1800.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 5, n, 1800.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;

-- Cuotas para Préstamo 6 (6 cuotas de 1600.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 6, n, 1600.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6
) AS numbers;

-- Cuotas para Préstamo 7 (18 cuotas de 1800.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 7, n, 1800.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION
    SELECT 16 UNION SELECT 17 UNION SELECT 18
) AS numbers;

-- Cuotas para Préstamo 8 (12 cuotas de 3000.00)
INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota)
SELECT 8, n, 3000.00
FROM (
    SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION
    SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION
    SELECT 11 UNION SELECT 12
) AS numbers;
    
DELIMITER $$

CREATE PROCEDURE FiltrarCuentas (
    IN p_CodCliente INT,
    IN p_CodTipoCuenta CHAR(1),
    IN p_Estado BOOLEAN
)
BEGIN
    SELECT *
    FROM Cuentas c
    WHERE
        (p_CodCliente IS NULL OR c.CodCliente = p_CodCliente) AND
        (p_CodTipoCuenta IS NULL OR c.CodTipoCuenta = p_CodTipoCuenta) AND
        (p_Estado IS NULL OR c.Estado = p_Estado);
END $$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE prestamosActivos (
	IN fechaDesde DATE,
    IN fechaHasta date
)
BEGIN

SELECT COUNT(*) AS PrestamosActivos
FROM Prestamos
WHERE Estado = 1
AND Deuda = 1
AND Fecha <= fechaHasta
AND DATE_ADD(Fecha, INTERVAL PlazoMeses MONTH) >= fechaDesde;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE prestamosAtrasados(
	IN fechaDesde DATE,
    IN fechaHasta date
)
BEGIN
SELECT COUNT(*) AS PrestamosAtrasados
FROM (
    SELECT 
        P.CodPrestamo,
        TIMESTAMPDIFF(MONTH, P.Fecha, LEAST(fechaHasta, DATE_ADD(P.Fecha, INTERVAL P.PlazoMeses MONTH))) AS CuotasEsperadas,
	(
	SELECT COUNT(*) 
		FROM Movimientos M 
		WHERE M.NroCuentaAsociado = P.NroCuentaAsociado
		AND M.CodTipoMovimiento = 'PP'
		AND M.Fecha BETWEEN P.Fecha AND fechaHasta
        ) AS CuotasPagadas
    FROM Prestamos P
    WHERE P.Estado = 1
      AND P.Deuda = 1
      AND P.Fecha <= fechaHasta
      AND DATE_ADD(P.Fecha, INTERVAL P.PlazoMeses MONTH) >= fechaDesde
) AS T
WHERE CuotasPagadas < CuotasEsperadas;
END$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE EliminarCliente (
    IN id INT
)
BEGIN
    UPDATE cuentas SET Estado = 0 WHERE CodCliente = id;
    UPDATE clientes SET Estado = 0 WHERE CodCliente = id;
    UPDATE usuarios SET Estado = 0 WHERE IdUsuario = (
	SELECT IdUsuario FROM clientes WHERE CodCliente = id
    );
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE aceptarPrestamo (
    IN p_codPrestamo INT
)
BEGIN
    DECLARE v_importe DECIMAL(12,2);
    DECLARE v_nroCuenta INT;
    DECLARE v_pagoMensual DECIMAL(12,2);
    DECLARE v_cuotasTotales INT;
    DECLARE v_numeroCuota INT DEFAULT 1;

    SELECT ImportePedido, NroCuentaAsociado, PagoMensual, CuotasTotales
    INTO v_importe, v_nroCuenta, v_pagoMensual, v_cuotasTotales
    FROM prestamos
    WHERE CodPrestamo = p_codPrestamo;

    UPDATE prestamos 
    SET Estado = 1
    WHERE CodPrestamo = p_codPrestamo;

    UPDATE cuentas 
    SET Saldo = Saldo + v_importe
    WHERE NroCuenta = v_nroCuenta;

    INSERT INTO movimientos (CodTipoMovimiento, NroCuentaAsociado, Detalle, Importe)
    VALUES ('AP', v_nroCuenta, 'Acreditación préstamo', v_importe);

    WHILE v_numeroCuota <= v_cuotasTotales DO
        INSERT INTO cuotas (CodPrestamo, NumeroCuota, MontoCuota)
        VALUES (p_codPrestamo, v_numeroCuota, v_pagoMensual);

        SET v_numeroCuota = v_numeroCuota + 1;
    END WHILE;

END $$

DELIMITER ;