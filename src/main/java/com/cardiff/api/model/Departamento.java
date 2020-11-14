package com.cardiff.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departamento_id")
	private Long departamentoId;
	
	@Column(name = "departamento_name")
	private String departamentoName;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionarioId;

	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getDepartamentoName() {
		return departamentoName;
	}

	public void setDepartamentoName(String departamentoName) {
		this.departamentoName = departamentoName;
	}

	public Funcionario getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Funcionario funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamentoId == null) ? 0 : departamentoId.hashCode());
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
		Departamento other = (Departamento) obj;
		if (departamentoId == null) {
			if (other.departamentoId != null)
				return false;
		} else if (!departamentoId.equals(other.departamentoId))
			return false;
		return true;
	}
	
	
	
}
