package br.com.tiago.logistica.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Campo {
	
	private String nome;
	private String mensagem;
}
