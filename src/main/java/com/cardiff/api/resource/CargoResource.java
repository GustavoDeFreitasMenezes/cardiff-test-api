package com.cardiff.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardiff.api.model.Cargo;
import com.cardiff.api.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoResource {

	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}
	
}
