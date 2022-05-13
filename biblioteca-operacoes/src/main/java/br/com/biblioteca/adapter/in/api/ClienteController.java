package br.com.biblioteca.adapter.in.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.biblioteca.domain.cliente.app.ClienteService;
import br.com.biblioteca.domain.cliente.model.Cliente;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> encontrarTodos() {
		List<Cliente> lista = service.encontrarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> encontrarPorId(@PathVariable Long id) {
		Cliente obj = service.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		Cliente obj = service.cadastrar(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente obj = service.editar(id, cliente);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
