package com.cardiff.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cardiff.api.model.Cargo;
import com.cardiff.api.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	CargoRepository cargoRepository;
	
	public List<Cargo> listar(){
		return cargoRepository.findAll();
	}
	
	public Cargo buscarPeloCodigo(@PathVariable Long cargoId){
		Cargo c = this.cargoRepository.findById(cargoId).orElseThrow(() -> new EmptyResultDataAccessException(1));	// se não encontrar retorna exceção
		return c;
	}
	
	public Cargo criar(Cargo cargo){
		return cargoRepository.save(cargo);
	}
	
	public void remover(Long cargoId){
		cargoRepository.deleteById(cargoId);
	}
	
	public Cargo atualizar(Long cargoId, Cargo cargo){
		Cargo c = buscarPeloCodigo(cargoId);			// consultando registro no BD 		
		BeanUtils.copyProperties(cargo, c, "cargoId");	// pegando as propriedades do cliente e setando no registro q veio do BD
		return cargoRepository.save(c);
	}
}
