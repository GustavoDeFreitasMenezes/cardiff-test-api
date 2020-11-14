package com.cardiff.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.repository.query.FuncionarioDepartamentoRepositoryQuery;

public interface FuncionarioDepartamentoRepository extends JpaRepository<FuncionarioDepartamento, Long>, FuncionarioDepartamentoRepositoryQuery{

}
