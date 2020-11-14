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
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Long funcionarioId;
	
	@Column(name = "funcionario_name")
	private String funcionarioName;
	
	@Column(name = "funcionario_age")
	private Integer funcionarioAge;
	
	@Column(name = "funcionario_birthday")
	private LocalDate funcionarioBirthday;
	
	@Column(name = "funcionario_document")
	private String funcionarioDocument;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargoId;

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getFuncionarioName() {
		return funcionarioName;
	}

	public void setFuncionarioName(String funcionarioName) {
		this.funcionarioName = funcionarioName;
	}

	public Integer getFuncionarioAge() {
		return funcionarioAge;
	}

	public void setFuncionarioAge(Integer funcionarioAge) {
		this.funcionarioAge = funcionarioAge;
	}

	public LocalDate getFuncionarioBirthday() {
		return funcionarioBirthday;
	}

	public void setFuncionarioBirthday(LocalDate funcionarioBirthday) {
		this.funcionarioBirthday = funcionarioBirthday;
	}

	public String getFuncionarioDocument() {
		return funcionarioDocument;
	}

	public void setFuncionarioDocument(String funcionarioDocument) {
		this.funcionarioDocument = funcionarioDocument;
	}

	public Cargo getCargoId() {
		return cargoId;
	}

	public void setCargoId(Cargo cargoId) {
		this.cargoId = cargoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionarioId == null) ? 0 : funcionarioId.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (funcionarioId == null) {
			if (other.funcionarioId != null)
				return false;
		} else if (!funcionarioId.equals(other.funcionarioId))
			return false;
		return true;
	}
	
	
	
}
