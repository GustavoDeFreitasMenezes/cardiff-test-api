package com.cardiff.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/{cargoId}")
	public Optional<Cargo> buscarPeloCodigo(@PathVariable Long cargoId) {
		return cargoRepository.findById(cargoId);
	}
	
	@PostMapping
	public ResponseEntity<Cargo> criar(@RequestBody Cargo categoria, HttpServletResponse response) {
		Cargo c = cargoRepository.save(categoria);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(c.getCargoId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(c);	// devolvendo o objeto criado no body
	}
	
}
