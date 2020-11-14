CREATE TABLE funcionario (
	funcionario_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	funcionario_name VARCHAR(50) NOT NULL,
	funcionario_age BIGINT(20) NOT NULL,
	funcionario_birthday DATE NOT NULL,
	funcionario_document VARCHAR(50) NOT NULL,
	cargo_id BIGINT(20) NOT NULL,
	FOREIGN KEY (cargo_id) REFERENCES cargo(cargo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('JESUS',    33, '1987-04-06', '111.111.111-11', 1);	
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('MARIA',    57, '1963-08-13', '222.222.222-22', 3);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('JOSE',     63, '1957-04-06', '333.333.333-33', 4);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('MADALENA', 44, '1976-11-01', '444.444.444-44', 2);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('PEDRO',    26, '1994-03-29', '555.555.555-55', 6);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('ANDRE',    18, '2002-07-24', '666.666.666-66', 7);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('TIAGO',    28, '1992-01-18', '777.777.777-77', 5);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('JOAO',     29, '1991-10-13', '888.888.888-88', 5);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('FELIPE',   21, '1999-07-07', '999.999.999-99', 7);
INSERT INTO funcionario (funcionario_name, funcionario_age, funcionario_birthday, funcionario_document, cargo_id) values ('MATEUS',   23, '1997-05-15', '000.000.000-00', 6);
