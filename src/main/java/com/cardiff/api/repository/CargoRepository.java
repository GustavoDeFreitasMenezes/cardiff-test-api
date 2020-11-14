package com.cardiff.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardiff.api.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
