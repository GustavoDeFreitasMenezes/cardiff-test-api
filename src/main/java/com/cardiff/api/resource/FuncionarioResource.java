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

import com.cardiff.api.model.Funcionario;
import com.cardiff.api.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioService.listar();		
	}
	
	@GetMapping("/{funcionarioId}")	
	public ResponseEntity<Funcionario> buscarPeloCodigo(@PathVariable Long funcionarioId){
		Funcionario f = funcionarioService.buscarPeloCodigo(funcionarioId);
		return f != null ? ResponseEntity.ok(f) : ResponseEntity.noContent().build();	// se nao tiver registro devolvo 404
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario f = funcionarioService.criar(funcionario);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{funcionarioId}")
			.buildAndExpand(f.getFuncionarioId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(f);	// devolvendo o objeto criado no body
	}
	
	@DeleteMapping("{funcionarioId}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long funcionarioId){
		funcionarioService.remover(funcionarioId);
	}
	
	@PutMapping("{funcionarioId}")	
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionario){
		Funcionario f = funcionarioService.atualizar(funcionarioId, funcionario);		
		return ResponseEntity.ok(f);
	}
	
}
