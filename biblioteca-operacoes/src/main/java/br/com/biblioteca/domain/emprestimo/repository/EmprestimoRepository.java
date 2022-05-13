package br.com.biblioteca.domain.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.domain.emprestimo.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
