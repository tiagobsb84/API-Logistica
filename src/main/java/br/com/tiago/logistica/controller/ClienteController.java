package br.com.tiago.logistica.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.logistica.models.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/cliente")
	public List<Cliente> listar(){
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Pedro");
		cliente1.setEmail("pedro@gmail.com");
		cliente1.setTelefone("11 98888-2222");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Fulano");
		cliente2.setEmail("fulano@gmail.com");
		cliente2.setTelefone("33 97777-1111");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
