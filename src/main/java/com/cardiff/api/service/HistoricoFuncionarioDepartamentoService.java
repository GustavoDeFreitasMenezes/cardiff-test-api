package com.cardiff.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardiff.api.model.HistoricoFuncionarioDepartamento;
import com.cardiff.api.repository.HistoricoFuncionarioDepartamentoRepository;

@Service
public class HistoricoFuncionarioDepartamentoService {

	@Autowired
	HistoricoFuncionarioDepartamentoRepository historicoFuncionarioDepartamentoRepository;
	
	public List<HistoricoFuncionarioDepartamento> listar(){
		return historicoFuncionarioDepartamentoRepository.findAll();
	}
	
	public HistoricoFuncionarioDepartamento buscarPeloCodigo(@PathVariable Long historicoFuncionarioDepartamentoId){
		HistoricoFuncionarioDepartamento hfd = this.historicoFuncionarioDepartamentoRepository.findById(historicoFuncionarioDepartamentoId).orElseThrow(() -> new EmptyResultDataAccessException(1));	// se não encontrar retorna exceção
		return hfd;
	}
	
	public HistoricoFuncionarioDepartamento criar(HistoricoFuncionarioDepartamento historicoFuncionarioDepartamento){
		return historicoFuncionarioDepartamentoRepository.save(historicoFuncionarioDepartamento);
	}
	
	
	
}
