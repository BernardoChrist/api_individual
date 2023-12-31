package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.services.LivroService;

@RestController // obrigatório para dizer que é um controller
@RequestMapping("/livros") // é o nome da entidade (no minusculo e no plural)- caminho do http

public class LivroController {

	@Autowired
	LivroService livroService; // estamos importando o service, para chamar os metodos de la

	@GetMapping // utilizar essa anotação quando queremos recuperar informações
	// o responseentity é utilizado para retornar também o codigo http - 200 ou 201
	// utilizamos dentro de um diamante, englobando a Lista
	public ResponseEntity<List<Livro>> listarLivros() { // o nome do metodo pode ser qualquer um,

		return new ResponseEntity<>(livroService.listarLivros(), HttpStatus.OK);
		// temos que utilizar o new responseentity desta maneira acima, com o diamante e
		// chamando o metodo do service ao lado, com o HttpStatus que o usuario quiser
	}

	@GetMapping("/resumido")
	public ResponseEntity<List<LivroResumidoDTO>> listarLivrosResumido() {

		return new ResponseEntity<>(livroService.listarLivrosResumidos(), HttpStatus.OK);

	}

	@GetMapping("/{codigoLivro}") // temos que usar o {} dessa forma para diferenciar do primeiro getmapping
	// o texto entre chaves tem que ser igual o do pathVariable
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer codigoLivro) {
		// o @PathVariable é para dizer que o parametro ID vai ser passado por path -
		// /id

		Livro livro = livroService.buscarLivroPorId(codigoLivro);

		if (livro == null)
			return new ResponseEntity<>(livroService.buscarLivroPorId(codigoLivro), HttpStatus.NOT_FOUND);

		else
			return new ResponseEntity<>(livroService.buscarLivroPorId(codigoLivro), HttpStatus.OK);

		// utilizamos essa estrutura para alterar o status - quando for nulo vai dar um
		// NotFound
	}

	// metodo DTO
	@GetMapping("/resumido/{codigoLivro}")
	public ResponseEntity<LivroResumidoDTO> buscarLivroResumidoPorId(@PathVariable Integer codigoLivro) {

		LivroResumidoDTO livroResDTO = livroService.buscarLivroResumidoPorId(codigoLivro);

		if (livroResDTO == null)
			return new ResponseEntity<>(livroResDTO, HttpStatus.NOT_FOUND);

		else
			return new ResponseEntity<>(livroResDTO, HttpStatus.OK);
	}

	@PostMapping // post é pq iremos salvar um objeto
	public ResponseEntity<Livro> salvarLivro(@RequestBody Livro novoLivro) {
		// o @RequestBody é pq vão ser passados varios dados, formando um body, json
		return new ResponseEntity<>(livroService.salvarLivro(novoLivro), HttpStatus.CREATED);
		// utilizar o CREATED sempre quando fizermos um Post
	}

	@PutMapping // put é pq iremos atualizar um objeto ja criado
	public ResponseEntity<Livro> atualizarLivro(@RequestBody Livro atualizaLivro) {
		return new ResponseEntity<>(livroService.atualizarLivro(atualizaLivro), HttpStatus.OK);
	}

	@DeleteMapping // delete é quando o metodo é para deletar
	public ResponseEntity<String> deletarLivro(@RequestBody Livro deletaLivro) {// string pq vamos retornar uma frase
		if (livroService.deletarLivro(deletaLivro) == true) { // chamamos fora pq temos que retornar uma string
			return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK); // é passado um texto pq espeara receber
																				// uma string

		} else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST); // é passado um texto pq
																								// espeara receber uma
																								// string

		}
	}
}
