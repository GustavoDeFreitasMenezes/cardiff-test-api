package com.cardiff.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cardiff.api.model.Cargo;
import com.cardiff.api.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoResource {

	@Autowired
	private CargoService cargoService;
	
	@GetMapping
	public List<Cargo> listar() {
		return cargoService.listar();		
	}
	
	@GetMapping("/{cargoId}")	
	public ResponseEntity<Cargo> buscarPeloCodigo(@PathVariable Long cargoId){
		Cargo c = cargoService.buscarPeloCodigo(cargoId);
		return c != null ? ResponseEntity.ok(c) : ResponseEntity.noContent().build();	// se nao tiver registro devolvo 404
	}
	
	@PostMapping
	public ResponseEntity<Cargo> criar(@RequestBody Cargo cargo, HttpServletResponse response) {
		Cargo c = cargoService.criar(cargo);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{cargoId}")
			.buildAndExpand(c.getCargoId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(c);	// devolvendo o objeto criado no body
	}
	
	@DeleteMapping("{cargoId}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cargoId){
		cargoService.remover(cargoId);
	}
	
	@PutMapping("{cargoId}")	
	public ResponseEntity<Cargo> atualizar(@PathVariable Long cargoId, @RequestBody Cargo cargo){
		Cargo c = cargoService.atualizar(cargoId, cargo);		
		return ResponseEntity.ok(c);
	}
	
}
