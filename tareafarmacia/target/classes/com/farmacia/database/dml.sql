CREATE DATABASE farmacia2;
USE farmacia2;

CREATE TABLE modo_administracion (
    idma INT  AUTO_INCREMENT,
    descripcion VARCHAR(60),
    CONSTRAINT pk_id_modoadministracion PRIMARY KEY (idma)
);

CREATE TABLE unidadmedida (
    idum INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_id_unidadmedida PRIMARY KEY (idum)
);

CREATE TABLE principio_activo (
    idpa INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    CONSTRAINT pk_id_principioactivo PRIMARY KEY (idpa)
);

CREATE TABLE pais (
    codigopais VARCHAR(5),
    nombre VARCHAR(50),
    CONSTRAINT pk_id_pais PRIMARY KEY (codigopais)
);

CREATE TABLE region (
    codigoreg VARCHAR(5) ,
    nombrereg VARCHAR(50),
    codigopais VARCHAR(5),
    CONSTRAINT pk_id_region PRIMARY KEY (codigoreg),
    CONSTRAINT fk_pais_region FOREIGN KEY (codigopais) REFERENCES pais(codigopais)
);

CREATE TABLE ciudad (
    codigociudad VARCHAR(5) ,
    nombreciudad VARCHAR(50),
    codigoreg VARCHAR(5),
    CONSTRAINT pk_id_CIUDAD PRIMARY KEY (codigociudad),
    CONSTRAINT fk_region_ciudad FOREIGN KEY  (codigoreg) REFERENCES region(codigoreg)
);

CREATE TABLE farmacia (
    idf INT AUTO_INCREMENT,
    nombrefarmacia VARCHAR(60),
    direccionfarmacia VARCHAR(100),
    longfarmacia float(8),
    latfarmacia float(8),
    codigociudadfarm VARCHAR(5),
    logofarmacia VARCHAR(50),
    CONSTRAINT pk_id_farmacia PRIMARY KEY (idf),
    CONSTRAINT fk_ciudad_farmacia FOREIGN KEY  (codigociudadfarm) REFERENCES ciudad(codigociudad)
   
);

CREATE TABLE laboratorio (
    codigolab INT AUTO_INCREMENT,
    nombrelab varchar(50),
    codigociudad varchar(5),
    CONSTRAINT pk_id_llaboratorio PRIMARY KEY (codigolab),
    CONSTRAINT fk_ciudad_laboratorio FOREIGN KEY  (codigociudad) REFERENCES ciudad(codigociudad)
);

CREATE TABLE medicina (
    id INT AUTO_INCREMENT,
    proceedings VARCHAR(100),
    nombre VARCHAR(100),
    registro_medico VARCHAR(100),
    descripcion text,
    descripcion_corto VARCHAR(60),
    nombre_rol VARCHAR(100),

    codigomodoadmin INT,
    codigoprincactivo INT,
    codigounidadmedida INT,
    codigolab INT,

    CONSTRAINT pk_id_medicine PRIMARY KEY (id),
    CONSTRAINT fk_modoadmin_medicina FOREIGN KEY (codigomodoadmin) REFERENCES modo_administracion(idma),
    CONSTRAINT fk_principioactivo_medicina FOREIGN KEY (codigoprincactivo) REFERENCES principio_activo(idpa),
    CONSTRAINT fk_unidadmedida_medicina FOREIGN KEY (codigounidadmedida) REFERENCES unidadmedida(idum),
    CONSTRAINT fk_laboratorio_medicina FOREIGN KEY (codigolab) REFERENCES laboratorio(codigolab)
);

CREATE TABLE farmaciamedicina (
    idfarmacia INT,
    idmedicinafarm INT,
    precio float(8),
    CONSTRAINT pk_id_farmaciamedicina PRIMARY KEY (idfarmacia,idmedicinafarm),
    CONSTRAINT fk_idfarmacia_farmaciamedicina FOREIGN KEY (idfarmacia) REFERENCES farmacia(idf),
    CONSTRAINT fk_idmedicinafarm_farmaciamedicina FOREIGN KEY (idmedicinafarm) REFERENCES medicina(id)
);

CREATE TABLE cliente (
    idcliente VARCHAR(15),
    nombrecliente VARCHAR(50),
    lastnombrecliente VARCHAR(50),
    codigociudadcliente VARCHAR(5),
    emailcliente VARCHAR(100),
    birthdate DATE,
    lon float(8),
    latitud float(8),
    CONSTRAINT pk_id_cliente PRIMARY KEY (idcliente),
    CONSTRAINT fk_codigociudadcustomer FOREIGN KEY (codigociudadcliente) REFERENCES ciudad(codigociudad)
);







