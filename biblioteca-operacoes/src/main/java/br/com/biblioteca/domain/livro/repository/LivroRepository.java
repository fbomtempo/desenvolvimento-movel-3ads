package br.com.biblioteca.domain.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.domain.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
