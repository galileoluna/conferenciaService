CREATE TABLE IF NOT EXISTS conferencias (
    id_evento   INTEGER      NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(128) NOT NULL,
    descripcion VARCHAR(128) NOT NULL,
    horadeinicio VARCHAR(128) NOT NULL,
    horadefinalizacion VARCHAR(128) NOT NULL,
    PRIMARY KEY (id_evento)
    );