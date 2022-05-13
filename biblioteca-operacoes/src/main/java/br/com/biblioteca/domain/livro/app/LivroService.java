package br.com.biblioteca.domain.livro.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.biblioteca.domain.livro.model.Livro;
import br.com.biblioteca.domain.livro.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public List<Livro> encontrarTodos() {
		return repository.findAll();
	}
	
	public Livro encontrarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Livro cadastrar(Livro livro) {
		return repository.save(livro);
	}
	
	
	public void deletar(Long id) {
		repository.findById(id)
			.map(livro -> {
				repository.delete(livro);
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Livro editar(Long id, Livro novoLivro) {
		return repository.findById(id)
				.map(antigoLivro -> {
					novoLivro.setId(antigoLivro.getId());
					return repository.save(novoLivro);
				})
				.get();
	}
}
