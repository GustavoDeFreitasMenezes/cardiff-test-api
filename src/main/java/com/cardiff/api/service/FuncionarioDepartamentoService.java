package com.cardiff.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.repository.FuncionarioDepartamentoRepository;
import com.cardiff.api.repository.filter.FuncionarioDepartamentoFilter;

@Service
public class FuncionarioDepartamentoService {

	@Autowired
	FuncionarioDepartamentoRepository funcionarioDepartamentoRepository;
	
	public List<FuncionarioDepartamento> pesquisar(FuncionarioDepartamentoFilter dff){
		return funcionarioDepartamentoRepository.pesquisar(dff);
	}
	
	public List<FuncionarioDepartamento> listar(){
		return funcionarioDepartamentoRepository.findAll();
	}
	
	public FuncionarioDepartamento buscarPeloCodigo(@PathVariable Long funcionarioDepartamentoId){
		FuncionarioDepartamento fd = this.funcionarioDepartamentoRepository.findById(funcionarioDepartamentoId).orElseThrow(() -> new EmptyResultDataAccessException(1));	// se não encontrar retorna exceção
		return fd;
	}
	
	public FuncionarioDepartamento criar(FuncionarioDepartamento funcionarioDepartamento){
		return funcionarioDepartamentoRepository.save(funcionarioDepartamento);
	}
	
	public void remover(Long funcionarioDepartamentoId){
		funcionarioDepartamentoRepository.deleteById(funcionarioDepartamentoId);
	}
	
	public FuncionarioDepartamento atualizar(Long funcionarioDepartamentoId, FuncionarioDepartamento funcionarioDepartamento){
		FuncionarioDepartamento fd = buscarPeloCodigo(funcionarioDepartamentoId);				// consultando registro no BD 		
		BeanUtils.copyProperties(funcionarioDepartamento, fd, "funcionarioDepartamentoId");		// pegando as propriedades do cliente e setando no registro q veio do BD
		return funcionarioDepartamentoRepository.save(fd);
	}
	
	
}
