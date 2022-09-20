package br.com.tiago.logistica.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.logistica.models.Cliente;

@RestController
public class ClienteController {
		
	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/cliente")
	public List<Cliente> listar(){
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}
}
