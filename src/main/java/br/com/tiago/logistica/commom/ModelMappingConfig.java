package br.com.tiago.logistica.commom;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
