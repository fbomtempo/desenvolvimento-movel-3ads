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

import br.com.biblioteca.domain.emprestimo.app.EmprestimoService;
import br.com.biblioteca.domain.emprestimo.model.Emprestimo;

@RestController
@RequestMapping(value = "api/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> encontrarTodos() {
		List<Emprestimo> lista = service.encontrarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> encontrarPorId(@PathVariable Long id) {
		Emprestimo obj = service.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> cadastrar(@RequestBody Emprestimo emprestimo) {
		Emprestimo obj = service.cadastrar(emprestimo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> editar(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
		Emprestimo obj = service.editar(id, emprestimo);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
