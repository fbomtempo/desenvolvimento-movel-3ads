package br.com.biblioteca.domain.emprestimo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.biblioteca.domain.emprestimo.model.Emprestimo;
import br.com.biblioteca.domain.emprestimo.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	public List<Emprestimo> encontrarTodos() {
		return repository.findAll();
	}
	
	public Emprestimo encontrarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Emprestimo cadastrar(Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}
	
	
	public void deletar(Long id) {
		repository.findById(id)
			.map(emprestimo -> {
				repository.delete(emprestimo);
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Emprestimo editar(Long id, Emprestimo novoEmprestimo) {
		return repository.findById(id)
				.map(antigoEmprestimo -> {
					novoEmprestimo.setId(antigoEmprestimo.getId());
					return repository.save(novoEmprestimo);
				})
				.get();
	}
}

