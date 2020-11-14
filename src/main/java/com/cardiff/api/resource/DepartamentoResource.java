package com.cardiff.api.resource;

import java.net.URI;
import java.util.List;

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

import com.cardiff.api.model.Departamento;
import com.cardiff.api.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoResource {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public List<Departamento> listar() {
		return departamentoService.listar();		
	}
	
	@GetMapping("/{departamentoId}")	
	public ResponseEntity<Departamento> buscarPeloCodigo(@PathVariable Long departamentoId){
		Departamento d = departamentoService.buscarPeloCodigo(departamentoId);
		return d != null ? ResponseEntity.ok(d) : ResponseEntity.noContent().build();	// se nao tiver registro devolvo 404
	}
	
	@PostMapping
	public ResponseEntity<Departamento> criar(@RequestBody Departamento departamento, HttpServletResponse response) {
		Departamento d = departamentoService.criar(departamento);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{departamentoId}")
			.buildAndExpand(d.getDepartamentoId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(d);	// devolvendo o objeto criado no body
	}
	
	@DeleteMapping("{departamentoId}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long departamentoId){
		departamentoService.remover(departamentoId);
	}
	
	@PutMapping("{departamentoId}")	
	public ResponseEntity<Departamento> atualizar(@PathVariable Long departamentoId, @RequestBody Departamento departamento){
		Departamento d = departamentoService.atualizar(departamentoId, departamento);		
		return ResponseEntity.ok(d);
	}
	
}
