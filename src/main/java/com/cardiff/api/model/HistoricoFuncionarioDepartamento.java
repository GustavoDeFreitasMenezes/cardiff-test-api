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
@Table(name = "hist_func_depto")
public class HistoricoFuncionarioDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hist_func_depto_id")
	private Long histFuncDeptoId;
	
	@Column(name = "hist_func_depto_data")
	private LocalDate histFuncDeptoData;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionarioId;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamentoId;

	public Long getHistFuncDeptoId() {
		return histFuncDeptoId;
	}

	public void setHistFuncDeptoId(Long histFuncDeptoId) {
		this.histFuncDeptoId = histFuncDeptoId;
	}

	public LocalDate getHistFuncDeptoData() {
		return histFuncDeptoData;
	}

	public void setHistFuncDeptoData(LocalDate histFuncDeptoData) {
		this.histFuncDeptoData = histFuncDeptoData;
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
		result = prime * result + ((histFuncDeptoId == null) ? 0 : histFuncDeptoId.hashCode());
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
		HistoricoFuncionarioDepartamento other = (HistoricoFuncionarioDepartamento) obj;
		if (histFuncDeptoId == null) {
			if (other.histFuncDeptoId != null)
				return false;
		} else if (!histFuncDeptoId.equals(other.histFuncDeptoId))
			return false;
		return true;
	}
	
	
	
}
