package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepo;

	// metodo de listar aluno
	public List<Autor> listarAutores() {
		return autorRepo.findAll();
	}

	// metodo listar aluno por id
	public Autor buscarAutorPorId(Integer codigoAutor) {
		return autorRepo.findById(codigoAutor).orElse(null);
	}

	// metodo salvar aluno
	public Autor salvarAutor(Autor novoAutor) {
		return autorRepo.save(novoAutor);
	}

	// metodo atualizar aluno
	public Autor atualizarAutor(Autor atualizaAutor) {
		return autorRepo.save(atualizaAutor);
	}

	// metodo deletar aluno
	public Boolean deletarAutor(Autor deletaAutor) {
		if (deletaAutor == null) {
			return false;
		}

		Autor autorExistente = buscarAutorPorId(deletaAutor.getCodigoAutor());

		if (autorExistente == null) {
			return false;
		}

		autorRepo.delete(deletaAutor);

		Autor autorContinuaExistindo = buscarAutorPorId(deletaAutor.getCodigoAutor());

		if (autorContinuaExistindo == null) {
			return true;
		}
		return false;

	}

}
