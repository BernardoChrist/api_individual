package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	// 5 métodos - CRUD
	// recuperar todos Livros
	// recuperar um Livro pela sua chave primária
	// salvar um novo Livro
	// atualizar um determinado Livro
	// deletar um determinado Livro

	@Autowired
	LivroRepository livroRepo;

	public List<Livro> listarLivros() { // List pq são varias editoras
		return livroRepo.findAll();
	}

	public Livro buscarLivroPorId(Integer codigoLivro) { // integer pq é o tipo da chave primária de Livro
		return livroRepo.findById(codigoLivro).get();
	}

	public Livro salvarLivro(Livro novoLivro) { // salvando um novo aluno na entidade Livro
		return livroRepo.save(novoLivro); // o .save ja vai salvar
	}

	public Livro atualizarEditora(Livro atualizaLivro) {
		return livroRepo.save(atualizaLivro);
	}

	public void deletarLivro(Livro deletaLivro) { // será void pq não irá devolver nd,
		livroRepo.delete(deletaLivro); // por isso também não tem o return
		/*
		 * Aluno confereAlunoDeletado =
		 * buscarAlunoPorId(aluno.getNumeroMatriculaAluno())
		 */
	}
}
