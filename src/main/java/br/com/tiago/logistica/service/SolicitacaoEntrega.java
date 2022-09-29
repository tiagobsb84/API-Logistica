package br.com.tiago.logistica.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.tiago.logistica.models.Cliente;
import br.com.tiago.logistica.models.Entrega;
import br.com.tiago.logistica.models.StatusEntrega;
import br.com.tiago.logistica.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntrega {

	private CatalogoClienteService catalogoService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoService.buscar(entrega.getCliente().getId());
				
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
