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

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.services.EditoraService;


@RestController // obrigatório para dizer que é um controller
@RequestMapping("/editoras") // é o nome da entidade (no minusculo e no plural)- caminho do http
public class EditoraController {

	@Autowired
	EditoraService editoraService; // estamos importando o service, para chamar os metodos de la

	@GetMapping // utilizar essa anotação quando queremos recuperar informações
	// o responseentity é utilizado para retornar também o codigo http - 200 ou 201
	// utilizamos dentro de um diamante, englobando a Lista
	public ResponseEntity<List<Editora>> listarEditoras() { // o nome do metodo pode ser qualquer um,

		return new ResponseEntity<>(editoraService.listarEditoras(), HttpStatus.OK);
		// temos que utilizar o new responseentity desta maneira acima, com o diamante e
		// chamando o metodo do service ao lado, com o HttpStatus que o usuario quiser
	}

	@GetMapping("/{codigoEditora}") // temos que usar o {} dessa forma para diferenciar do primeiro getmapping
	// o texto entre chaves tem que ser igual o do pathVariable
	public ResponseEntity<Editora> buscarEditoraPorId(@PathVariable Integer codigoEditora) {
		// o @PathVariable é para dizer que o parametro ID vai ser passado por path -
		// /id
		
		Editora editora = editoraService.buscarEditoraPorId(codigoEditora);
		
		if(editora == null)
			return new ResponseEntity<>(editoraService.buscarEditoraPorId(codigoEditora), HttpStatus.NOT_FOUND);
		
		else
			return new ResponseEntity<>(editoraService.buscarEditoraPorId(codigoEditora), HttpStatus.OK);
		//utilizamos essa estrutura para alterar o status - quando for nulo vai dar um NotFound
	}

	@PostMapping // post é pq iremos salvar um objeto
	public ResponseEntity<Editora> salvarEditora(@RequestBody Editora novaEditora) {
		// o @RequestBody é pq vão ser passados varios dados, formando um body, json
		return new ResponseEntity<>(editoraService.salvarEditora(novaEditora), HttpStatus.CREATED);
		// utilizar o CREATED sempre quando fizermos um Post
	}

	@PutMapping // put é pq iremos atualizar um objeto ja criado
	public ResponseEntity<Editora> atualizarEditora(@RequestBody Editora atualizaEditora) {
		return new ResponseEntity<>(editoraService.atualizarEditora(atualizaEditora), HttpStatus.OK);
	}

	@DeleteMapping // delete é quando o metodo é para deletar
	public ResponseEntity<String> deletarEditora(@RequestBody Editora deletaEditora) {// string pq vamos retornar uma frase
		if (editoraService.deletarEditora(deletaEditora) == true) { // chamamos fora pq temos que retornar uma string
			return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK); // é passado um texto pq espeara receber
																				// uma string

		} else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST); // é passado um texto pq
																								// espeara receber uma
																								// string

		}
	}
}
