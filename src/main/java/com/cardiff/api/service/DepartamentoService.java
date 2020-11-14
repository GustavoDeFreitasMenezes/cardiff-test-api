package com.cardiff.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardiff.api.model.Departamento;
import com.cardiff.api.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;
	
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}
	
	public Departamento buscarPeloCodigo(@PathVariable Long departamentoId){
		Departamento d = this.departamentoRepository.findById(departamentoId).orElseThrow(() -> new EmptyResultDataAccessException(1));	// se não encontrar retorna exceção
		return d;
	}
	
	public Departamento criar(Departamento departamento){
		return departamentoRepository.save(departamento);
	}
	
	public void remover(Long departamentoId){
		departamentoRepository.deleteById(departamentoId);
	}
	
	public Departamento atualizar(Long departamentoId, Departamento departamento){
		Departamento d = buscarPeloCodigo(departamentoId);				// consultando registro no BD 		
		BeanUtils.copyProperties(departamento, d, "departamentoId");	// pegando as propriedades do cliente e setando no registro q veio do BD
		return departamentoRepository.save(d);
	}
	
}
