package br.com.tiago.logistica.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.tiago.logistica.exception.NegocioException;
import br.com.tiago.logistica.models.Cliente;
import br.com.tiago.logistica.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salva(Cliente cliente) {
		boolean EmailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(EmailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void deletar(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
