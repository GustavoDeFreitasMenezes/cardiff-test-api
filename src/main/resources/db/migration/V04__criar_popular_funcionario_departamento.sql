CREATE TABLE funcionario_departamento (
	funcionario_departamento_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	funcionario_departamento_data DATE NOT NULL,
	departamento_id BIGINT(20) NOT NULL,
	funcionario_id BIGINT(20) NOT NULL,	
	FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id),
	FOREIGN KEY (departamento_id) REFERENCES departamento(departamento_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO funcionario_departamento (funcionario_departamento_data, departamento_id, funcionario_id) values ('2005-06-09', 4, 1);
INSERT INTO funcionario_departamento (funcionario_departamento_data, departamento_id, funcionario_id) values ('2005-06-09', 1, 3);
INSERT INTO funcionario_departamento (funcionario_departamento_data, departamento_id, funcionario_id) values ('2005-06-09', 2, 4);
