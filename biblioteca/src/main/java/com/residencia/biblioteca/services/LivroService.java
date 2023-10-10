package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
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

	public List<Livro> listarLivros() { // List pq são varias livros
		return livroRepo.findAll();
	}

	public Livro buscarLivroPorId(Integer codigoLivro) { // integer pq é o tipo da chave primária de Livro
		return livroRepo.findById(codigoLivro).orElse(null);
		// utilizamos o orElse, caso o numero do ID não exista, seria uma exception -
				// entao o que tivermos dentro do orElse, irá ser passado na pesquisa quando o
				// ID não for encontrado - - Caso o Id é encontrado, retorna o ID como se fosse
				// um .get()
	}

	public Livro salvarLivro(Livro novoLivro) { // salvando um novo aluno na entidade Livro
		return livroRepo.save(novoLivro); // o .save ja vai salvar
	}

	public Livro atualizarLivro(Livro atualizaLivro) {
		return livroRepo.save(atualizaLivro);
	}

	public Boolean deletarLivro(Livro deletaLivro) { // boolena pq é mais facil de tratar no controller

		if (deletaLivro == null) {
			return false; // aqui estamos vendo se o livro inserido para deletar é nulo
		}

		Livro livroExistente = buscarLivroPorId(deletaLivro.getCodigoLivro());

		if (livroExistente == null) {
			return false; // aqui etamos vendo se o livro existe no banco
		}

		livroRepo.delete(deletaLivro);

		Livro livroContinuaExistindo = buscarLivroPorId(deletaLivro.getCodigoLivro());

		if (livroContinuaExistindo == null) {
			return true;
		}
		return false;

	}
}
