package com.cardiff.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarioDepartamento")
public class FuncionarioDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_departamento_id")
	private Long funcionarioDepartamentoId;
	
	@Column(name = "funcionario_departamento_data")
	private LocalDate funcionarioDepartamentoData;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionarioId;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamentoId;

	public Long getFuncionarioDepartamentoId() {
		return funcionarioDepartamentoId;
	}

	public void setFuncionarioDepartamentoId(Long funcionarioDepartamentoId) {
		this.funcionarioDepartamentoId = funcionarioDepartamentoId;
	}

	public LocalDate getFuncionarioDepartamentoData() {
		return funcionarioDepartamentoData;
	}

	public void setFuncionarioDepartamentoData(LocalDate funcionarioDepartamentoData) {
		this.funcionarioDepartamentoData = funcionarioDepartamentoData;
	}

	public Funcionario getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Funcionario funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Departamento getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Departamento departamentoId) {
		this.departamentoId = departamentoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionarioDepartamentoId == null) ? 0 : funcionarioDepartamentoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioDepartamento other = (FuncionarioDepartamento) obj;
		if (funcionarioDepartamentoId == null) {
			if (other.funcionarioDepartamentoId != null)
				return false;
		} else if (!funcionarioDepartamentoId.equals(other.funcionarioDepartamentoId))
			return false;
		return true;
	}
	
	
	
}
