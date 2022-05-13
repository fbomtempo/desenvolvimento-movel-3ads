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

import br.com.biblioteca.domain.livro.app.LivroService;
import br.com.biblioteca.domain.livro.model.Livro;

@RestController
@RequestMapping(value = "api/livros")
public class LivroController {

	@Autowired
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> encontrarTodos() {
		List<Livro> lista = service.encontrarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> encontrarPorId(@PathVariable Long id) {
		Livro obj = service.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
		Livro obj = service.cadastrar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> editar(@PathVariable Long id, @RequestBody Livro livro) {
		Livro obj = service.editar(id, livro);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
