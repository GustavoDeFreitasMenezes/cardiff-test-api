package com.cardiff.api.repository.query;

import java.util.List;

import com.cardiff.api.model.HistoricoFuncionarioDepartamento;
import com.cardiff.api.repository.filter.HistoricoFuncionarioDepartamentoFilter;

public interface HistoricoFuncionarioDepartamentoRepositoryQuery {

	public List<HistoricoFuncionarioDepartamento> pesquisar(HistoricoFuncionarioDepartamentoFilter h);
	
}
