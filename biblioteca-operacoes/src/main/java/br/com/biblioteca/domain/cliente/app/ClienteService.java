package br.com.biblioteca.domain.cliente.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.biblioteca.domain.cliente.model.Cliente;
import br.com.biblioteca.domain.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> encontrarTodos() {
		return repository.findAll();
	}
	
	public Cliente encontrarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Cliente cadastrar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	
	public void deletar(Long id) {
		repository.findById(id)
			.map(cliente -> {
				repository.delete(cliente);
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Cliente editar(Long id, Cliente novoCliente) {
		return repository.findById(id)
				.map(antigoCliente -> {
					novoCliente.setId(antigoCliente.getId());
					return repository.save(novoCliente);
				})
				.get();
	}
}
