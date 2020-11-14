package com.cardiff.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cargo_id")
	private Long cargoId;
	
	@Column(name = "cargo_name")
	private String cargoName;
	
	public Long getCargoId() {
		return cargoId;
	}
	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargoId == null) ? 0 : cargoId.hashCode());
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
		Cargo other = (Cargo) obj;
		if (cargoId == null) {
			if (other.cargoId != null)
				return false;
		} else if (!cargoId.equals(other.cargoId))
			return false;
		return true;
	}
	
}
