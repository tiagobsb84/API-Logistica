package br.com.tiago.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiago.logistica.models.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
