package br.com.tiago.logistica.modeldto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.tiago.logistica.models.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;
	private String nomeCliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
}
