package br.com.biblioteca.domain.livro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 75)
	private String titulo;
	
	@Column(nullable = false, length = 150)
	private String autor;
	
	@Column(nullable = false, length = 50)
	private String editora;
	
	@Column(nullable = true)
	private Integer ano;
	
}
