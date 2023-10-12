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

import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	AutorService autorService;

	@GetMapping
	public ResponseEntity<List<Autor>> listarAutores() {
		return new ResponseEntity<>(autorService.listarAutores(), HttpStatus.OK);
	}

	@GetMapping("/{codigoAutor}")
	public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Integer codigoAutor) {

		Autor autor = autorService.buscarAutorPorId(codigoAutor);

		if (autor == null)
			return new ResponseEntity<>(autorService.buscarAutorPorId(codigoAutor), HttpStatus.NOT_FOUND);

		else
			return new ResponseEntity<>(autorService.buscarAutorPorId(codigoAutor), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Autor> salvarAutor(@RequestBody Autor novaAutor) {
		return new ResponseEntity<>(autorService.salvarAutor(novaAutor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Autor> atualizarAutor(@RequestBody Autor atualizaAutor) {
		return new ResponseEntity<>(autorService.atualizarAutor(atualizaAutor), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarAutor(@RequestBody Autor deletaAutor) {
		if (autorService.deletarAutor(deletaAutor) == true) {
			return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);

		}
	}
}
