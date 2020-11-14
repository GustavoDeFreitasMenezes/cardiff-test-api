package com.cardiff.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardiff.api.model.Funcionario;
import com.cardiff.api.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscarPeloCodigo(@PathVariable Long funcionarioId){
		Funcionario f = this.funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new EmptyResultDataAccessException(1));	// se não encontrar retorna exceção
		return f;
	}
	
	public Funcionario criar(Funcionario funcionario){
		return funcionarioRepository.save(funcionario);
	}
	
	public void remover(Long funcionarioId){
		funcionarioRepository.deleteById(funcionarioId);
	}
	
	public Funcionario atualizar(Long funcionarioId, Funcionario funcionario){
		Funcionario f = buscarPeloCodigo(funcionarioId);			// consultando registro no BD 		
		BeanUtils.copyProperties(funcionario, f, "funcionarioId");	// pegando as propriedades do cliente e setando no registro q veio do BD
		return funcionarioRepository.save(f);
	}
	
}
