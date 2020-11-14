package com.cardiff.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardiff.api.model.HistoricoFuncionarioDepartamento;
import com.cardiff.api.repository.query.HistoricoFuncionarioDepartamentoRepositoryQuery;

public interface HistoricoFuncionarioDepartamentoRepository extends JpaRepository<HistoricoFuncionarioDepartamento, Long>, HistoricoFuncionarioDepartamentoRepositoryQuery{

}
