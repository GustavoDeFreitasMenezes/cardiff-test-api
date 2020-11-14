CREATE TABLE cargo (
	cargo_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	cargo_name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO cargo (cargo_name) values ('PRESIDENTE');
INSERT INTO cargo (cargo_name) values ('GERENTE');
INSERT INTO cargo (cargo_name) values ('SUPERVISOR');
INSERT INTO cargo (cargo_name) values ('DIRETOR');
INSERT INTO cargo (cargo_name) values ('ANALISTA');
INSERT INTO cargo (cargo_name) values ('PROGRAMADOR');
INSERT INTO cargo (cargo_name) values ('ESTAGIARIO');