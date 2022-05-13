package br.com.biblioteca.domain.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.domain.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
