package br.com.tiago.logistica.controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.logistica.models.Entrega;
import br.com.tiago.logistica.service.SolicitacaoEntrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntrega solicitacaoEntrega;
	
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Entrega solicitar(@RequestBody Entrega entrega) {
		return solicitacaoEntrega.solicitar(entrega);
	}
}
