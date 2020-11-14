package com.cardiff.api.repository.query;

import java.util.List;

import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.repository.filter.FuncionarioDepartamentoFilter;

public interface FuncionarioDepartamentoRepositoryQuery {

	public List<FuncionarioDepartamento> pesquisar(FuncionarioDepartamentoFilter dff);
	
}
