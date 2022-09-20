package br.com.tiago.logistica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.logistica.models.Cliente;
import br.com.tiago.logistica.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {
		
	private ClienteRepository clienteRepository;

	@GetMapping("/cliente")
	public List<Cliente> listar(){
		return clienteRepository.findByNomeContaining("Sousa");
	}
}
