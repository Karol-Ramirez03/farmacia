INSERT INTO modo_administracion (descripcion) VALUES 
('Oral'), 
('Intravenosa'), 
('Intramuscular'), 
('Subcutánea'), 
('Tópica'), 
('Transdérmica'), 
('Inhalatoria'), 
('Ótica'), 
('Nasal'), 
('Rectal');

INSERT INTO unidadmedida (nombre) VALUES ('Miligramos'), 
('Gramos'), 
('Unidades'), 
('Mililitros'), 
('Litros'), 
('Paquetes'), 
('Cajas'), 
('Frascos'), 
('Tubos'), 
('Ampollas');

INSERT INTO principio_activo (nombre) VALUES 
('Ibuprofeno'), 
('Paracetamol'), 
('Amoxicilina'), 
('Aspirina'), 
('Metformina'), 
('Simvastatina'), 
('Loratadina'), 
('Cetirizina'), 
('Losartán'), 
('Omeprazol');

INSERT INTO pais (codigopais, nombre) VALUES 
('CO', 'Colombia'), 
('US', 'Estados Unidos'), 
('ES', 'España'), 
('MX', 'México'), 
('AR', 'Argentina'), 
('PE', 'Perú'), 
('VE', 'Venezuela'), 
('CL', 'Chile'), 
('EC', 'Ecuador'), 
('BR', 'Brasil');

INSERT INTO region (codigoreg, nombrereg, codigopais) VALUES 
('01', 'Antioquia', 'CO'), 
('02', 'California', 'US'), 
('03', 'Madrid', 'ES'), 
('04', 'Ciudad de México', 'MX'), 
('05', 'Buenos Aires', 'AR'), 
('06', 'Cuzco', 'PE'), 
('07', 'Miranda', 'VE'), 
('08', 'Santiago', 'CL'), 
('09', 'Pichincha', 'EC'), 
('10', 'Sao Paulo', 'BR');

INSERT INTO ciudad (codigociudad, nombreciudad, codigoreg) VALUES 
('001', 'Medellín', '01'), 
('002', 'Los Ángeles', '02'), 
('003', 'Alcalá de Henares', '03'), 
('004', 'Tlalpan', '04'), 
('005', 'Mar del Plata', '05'), 
('006', 'Machu Picchu', '06'), 
('007', 'Caracas', '07'), 
('008', 'Valparaíso', '08'), 
('009', 'Quito', '09'), 
('010', 'Campinas', '10');

INSERT INTO farmacia (nombrefarmacia, direccionfarmacia, longfarmacia, latfarmacia, codigociudadfarm, logofarmacia) VALUES 
('Farmacia Central', 'Calle 50 #10-20', -75.5812, 6.217, '001', 'logo1.png'), 
('Salud Total', 'Avenida Siempre Viva 123', -118.2437, 34.0522, '002', 'logo2.png'), 
('Farmacia Madrid', 'Gran Via 28', -3.7038, 40.4168, '003', 'logo3.png'), 
('Farmacon', 'Insurgentes Sur 3000', -99.1332, 19.4326, '004', 'logo4.png'), 
('Farmacias del Mar', 'Av. Costanera 455', -57.5575, -38.0023, '005', 'logo5.png'), 
('Boticas Cuzco', 'Plaza de Armas 12', -72.545, -13.1631, '006', 'logo6.png'), 
('Farmacia Miraflores', 'Calle Bolívar 50', -66.9036, 10.4806, '007', 'logo7.png'), 
('FarmaChile', 'Alameda 1020', -70.6693, -33.4489, '008', 'logo8.png'), 
('EcoFarma', 'Av. Amazonas 456', -78.4678, -0.1807, '009', 'logo9.png'), 
('Saúde e Vida', 'Rua das Palmeiras 300', -47.0608, -22.9099, '010', 'logo10.png');


INSERT INTO laboratorio (nombrelab, codigociudad) VALUES 
('LaboMed', '001'), 
('BioHealth', '002'), 
('Genéricos Españoles', '003'), 
('MexiPharma', '004'), 
('ArgenLab', '005'), 
('IncaLab', '006'), 
('VeneLab', '007'), 
('ChilePharma', '008'), 
('EcoLab Ecuador', '009'), 
('BrasilPharm', '010');

INSERT INTO medicina (proceedings, nombre, registro_medico, descripcion, descripcion_corto, nombre_rol, codigomodoadmin, codigoprincactivo, codigounidadmedida, codigolab) VALUES 
('RX001', 'Amoxicilina', 'RM123', 'Antibiótico para infecciones bacterianas', 'Antibiótico', 'Antibacterial', 1, 3, 2, 1),
('RX002', 'Paracetamol', 'RM124', 'Analgésico y antipirético', 'Analgésico', 'Analgésico', 1, 2, 1, 2),
('RX003', 'Ibuprofeno', 'RM125', 'Antiinflamatorio no esteroideo', 'Antiinflamatorio', 'AINE', 1, 1, 1, 3),
('RX004', 'Aspirina', 'RM126', 'Analgésico, antipirético y antiinflamatorio', 'Analgésico', 'Antiinflamatorio', 1, 4, 1, 4),
('RX005', 'Cetirizina', 'RM127', 'Antihistamínico para alergias', 'Antihistamínico', 'Antialérgico', 2, 8, 2, 5),
('RX006', 'Metformina', 'RM128', 'Tratamiento para la diabetes tipo 2', 'Antidiabético', 'Diabetes', 3, 5, 3, 6),
('RX007', 'Simvastatina', 'RM129', 'Medicamento para el colesterol alto', 'Hipolipemiante', 'Colesterol', 2, 6, 1, 7),
('RX008', 'Losartán', 'RM130', 'Tratamiento para la hipertensión arterial', 'Antihipertensivo', 'Hipertensión', 3, 9, 1, 8),
('RX009', 'Omeprazol', 'RM131', 'Inhibidor de la bomba de protones para la acidez', 'Antiacido', 'Acidez', 2, 10, 2, 9),
('RX010', 'Loratadina', 'RM132', 'Antihistamínico para alergias', 'Antihistamínico', 'Antialérgico', 1, 7, 1, 10);

INSERT INTO farmaciamedicina (idfarmacia, idmedicinafarm, precio) VALUES 
(1, 1, 20000),
(2, 2, 15000),
(3, 3, 25000),
(4, 4, 30000),
(5, 5, 18000),
(6, 6, 22000),
(7, 7, 35000),
(8, 8, 27500),
(9, 9, 32000),
(10, 10, 21000);

INSERT INTO cliente (idcliente, nombrecliente, lastnombrecliente, codigociudadcliente, emailcliente, birthdate, lon, latitud) VALUES 
('C001', 'Juan', 'Pérez', '001', 'juan.perez@example.com', '1985-06-15', -75.5812, 6.217),
('C002', 'María', 'González', '002', 'maria.gonzalez@example.com', '1992-03-22', -118.2437, 34.0522),
('C003', 'Carlos', 'López', '003', 'carlos.lopez@example.com', '1988-11-30', -3.7038, 40.4168),
('C004', 'Ana', 'Martínez', '004', 'ana.martinez@example.com', '1990-07-19', -99.1332, 19.4326),
('C005', 'Luis', 'Hernández', '005', 'luis.hernandez@example.com', '1974-02-12', -57.5575, -38.0023),
('C006', 'Lucía', 'García', '006', 'lucia.garcia@example.com', '2000-01-06', -72.545, -13.1631),
('C007', 'Diego', 'Morales', '007', 'diego.morales@example.com', '1995-05-23', -66.9036, 10.4806),
('C008', 'Sofía', 'Fernández', '008', 'sofia.fernandez@example.com', '1983-09-11', -70.6693, -33.4489),
('C009', 'Miguel', 'Álvarez', '009', 'miguel.alvarez@example.com', '1979-12-17', -78.4678, -0.1807),
('C010', 'Patricia', 'Rojas', '010', 'patricia.rojas@example.com', '1986-04-25', -47.0608, -22.9099);

