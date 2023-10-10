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

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.services.EmprestimoService;


@RestController // obrigatório para dizer que é um controller
@RequestMapping("/emprestimos") // é o nome da entidade (no minusculo e no plural)- caminho do http
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService; // estamos importando o service, para chamar os metodos de la

	@GetMapping // utilizar essa anotação quando queremos recuperar informações
	// o responseentity é utilizado para retornar também o codigo http - 200 ou 201
	// utilizamos dentro de um diamante, englobando a Lista
	public ResponseEntity<List<Emprestimo>> listarEmprestimos() { // o nome do metodo pode ser qualquer um,

		return new ResponseEntity<>(emprestimoService.listarEmprestimos(), HttpStatus.OK);
		// temos que utilizar o new responseentity desta maneira acima, com o diamante e
		// chamando o metodo do service ao lado, com o HttpStatus que o usuario quiser
	}

	@GetMapping("/{codigoEmprestimo}") // temos que usar o {} dessa forma para diferenciar do primeiro getmapping
	// o texto entre chaves tem que ser igual o do pathVariable
	public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Integer codigoEmprestimo) {
		// o @PathVariable é para dizer que o parametro ID vai ser passado por path -
		// /id
		
	Emprestimo emprestimo = emprestimoService.buscarEmprestimoPorId(codigoEmprestimo);
		
	if(emprestimo == null)
		return new ResponseEntity<>(emprestimoService.buscarEmprestimoPorId(codigoEmprestimo), HttpStatus.NOT_FOUND);
	
	else
		return new ResponseEntity<>(emprestimoService.buscarEmprestimoPorId(codigoEmprestimo), HttpStatus.OK);
	
	//utilizamos essa estrutura para alterar o status - quando for nulo vai dar um NotFound
	}

	@PostMapping // post é pq iremos salvar um objeto
	public ResponseEntity<Emprestimo> salvarEmprestimo(@RequestBody Emprestimo novoEmprestimo) {
		// o @RequestBody é pq vão ser passados varios dados, formando um body, json
		return new ResponseEntity<>(emprestimoService.salvarEmprestimo(novoEmprestimo), HttpStatus.CREATED);
		// utilizar o CREATED sempre quando fizermos um Post
	}

	@PutMapping // put é pq iremos atualizar um objeto ja criado
	public ResponseEntity<Emprestimo> atualizarEmprestimo(@RequestBody Emprestimo atualizaEmprestimo) {
		return new ResponseEntity<>(emprestimoService.atualizarEmprestimo(atualizaEmprestimo), HttpStatus.OK);
	}

	@DeleteMapping // delete é quando o metodo é para deletar
	public ResponseEntity<String> deletarEmprestimo(@RequestBody Emprestimo deletaEmprestimo) {// string pq vamos retornar uma frase
		if (emprestimoService.deletarEmprestimo(deletaEmprestimo) == true) { // chamamos fora pq temos que retornar uma string
			return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK); // é passado um texto pq espeara receber
																				// uma string

		} else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST); // é passado um texto pq
																								// espeara receber uma
																								// string

		}
	}
}
