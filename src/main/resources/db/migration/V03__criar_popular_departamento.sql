CREATE TABLE departamento (
	departamento_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	departamento_name VARCHAR(50) NOT NULL,
	funcionario_id BIGINT(20) NOT NULL,	
	FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO departamento (departamento_name, funcionario_id) values ('DESENVOLVIMENTO', 3);
INSERT INTO departamento (departamento_name, funcionario_id) values ('ADMINISTRACAO', 4);
INSERT INTO departamento (departamento_name, funcionario_id) values ('RECURSOS HUMANOS', 2);
INSERT INTO departamento (departamento_name, funcionario_id) values ('PRESIDENCIA', 1);
