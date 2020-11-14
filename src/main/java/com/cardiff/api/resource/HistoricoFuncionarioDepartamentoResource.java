package com.cardiff.api.resource;

import java.net.URI;
import java.util.List;

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

import com.cardiff.api.model.HistoricoFuncionarioDepartamento;
import com.cardiff.api.repository.filter.HistoricoFuncionarioDepartamentoFilter;
import com.cardiff.api.service.HistoricoFuncionarioDepartamentoService;

@RestController
@RequestMapping("/histFuncDepto")
public class HistoricoFuncionarioDepartamentoResource {

	@Autowired
	private HistoricoFuncionarioDepartamentoService historicoFuncionarioDepartamentoService;
	
	@GetMapping("/pesquisar")
	public List<HistoricoFuncionarioDepartamento> pesquisar(HistoricoFuncionarioDepartamentoFilter h) {
		return historicoFuncionarioDepartamentoService.pesquisar(h);		
	}
	
	@GetMapping
	public List<HistoricoFuncionarioDepartamento> listar() {
		return historicoFuncionarioDepartamentoService.listar();		
	}
	
	@GetMapping("/{histFuncDeptoId}")	
	public ResponseEntity<HistoricoFuncionarioDepartamento> buscarPeloCodigo(@PathVariable Long histFuncDeptoId){
		HistoricoFuncionarioDepartamento hfd = historicoFuncionarioDepartamentoService.buscarPeloCodigo(histFuncDeptoId);
		return hfd != null ? ResponseEntity.ok(hfd) : ResponseEntity.noContent().build();	// se nao tiver registro devolvo 404
	}
	
	@PostMapping
	public ResponseEntity<HistoricoFuncionarioDepartamento> criar(@RequestBody HistoricoFuncionarioDepartamento historicoFuncionarioDepartamento, HttpServletResponse response) {
		HistoricoFuncionarioDepartamento hfd = historicoFuncionarioDepartamentoService.criar(historicoFuncionarioDepartamento);
		
		// preenchendo uma URL no cabeçalho da resposta (Location) 
		// pro cliente saber qual URL ele pode consultar o objeto que acabou de ser criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{histFuncDeptoId}")
			.buildAndExpand(hfd.getHistFuncDeptoId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(hfd);	// devolvendo o objeto criado no body
	}
	
	
	
}
