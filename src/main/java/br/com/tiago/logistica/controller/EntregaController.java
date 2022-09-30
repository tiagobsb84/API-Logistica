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

import br.com.tiago.logistica.assembler.EntregaAssembler;
import br.com.tiago.logistica.modeldto.EntregaModel;
import br.com.tiago.logistica.models.Entrega;
import br.com.tiago.logistica.models.input.EntregaInput;
import br.com.tiago.logistica.repository.EntregaRepository;
import br.com.tiago.logistica.service.SolicitacaoEntrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntrega solicitacaoEntrega;
	
	private EntregaAssembler entregaAssembler;
	
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntrega.solicitar(novaEntrega);
		
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaModel> lista() {
		return entregaAssembler.toCollection(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
}
