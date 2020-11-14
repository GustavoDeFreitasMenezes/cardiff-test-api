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

import com.cardiff.api.model.FuncionarioDepartamento;
import com.cardiff.api.service.FuncionarioDepartamentoService;

@RestController
@RequestMapping("/funcionarioDepartamento")
public class FuncionarioDepartamentoResource {

	@Autowired
	private FuncionarioDepartamentoService funcionarioDepartamentoService;
	
	@GetMapping
	public List<FuncionarioDepartamento> listar() {
		return funcionarioDepartamentoService.listar();		
	}
	
	@GetMapping("/{funcionarioDepartamentoId}")	
	public ResponseEntity<FuncionarioDepartamento> buscarPeloCodigo(@PathVariable Long funcionarioDepartamentoId){
		FuncionarioDepartamento fd = funcionarioDepartamentoService.buscarPeloCodigo(funcionarioDepartamentoId);
		return fd != null ? ResponseEntity.ok(fd) : ResponseEntity.noContent().build();	// se nao tiver registro devolvo 404
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDepartamento> criar(@RequestBody FuncionarioDepartamento funcionarioDepartamento, HttpServletResponse response) {
		FuncionarioDepartamento fd = funcionarioDepartamentoService.criar(funcionarioDepartamento);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{funcionarioDepartamentoId}")
			.buildAndExpand(fd.getFuncionarioDepartamentoId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(fd);	// devolvendo o objeto criado no body
	}
	
	@DeleteMapping("{funcionarioDepartamentoId}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long funcionarioDepartamentoId){
		funcionarioDepartamentoService.remover(funcionarioDepartamentoId);
	}
	
	@PutMapping("{funcionarioDepartamentoId}")	
	public ResponseEntity<FuncionarioDepartamento> atualizar(@PathVariable Long funcionarioDepartamentoId, @RequestBody FuncionarioDepartamento funcionarioDepartamento){
		FuncionarioDepartamento fd = funcionarioDepartamentoService.atualizar(funcionarioDepartamentoId, funcionarioDepartamento);		
		return ResponseEntity.ok(fd);
	}
	
}
