package com.cardiff.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardiff.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
