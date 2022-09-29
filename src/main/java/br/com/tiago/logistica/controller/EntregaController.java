package br.com.tiago.logistica.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.logistica.models.Entrega;
import br.com.tiago.logistica.repository.EntregaRepository;
import br.com.tiago.logistica.service.SolicitacaoEntrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntrega solicitacaoEntrega;
	
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntrega.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> lista() {
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
